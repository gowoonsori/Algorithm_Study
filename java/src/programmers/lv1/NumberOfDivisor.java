package programmers.lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfDivisor {
    public int solution(int left, int right) {
        int answer = 0;

        int cnt;
        for(int num = left; num <= right; num++){
            cnt = countDivisor(num);
            answer += cnt%2 == 0 ? num : (num * -1) ;
        }

        return answer;
    }
    public int countDivisor(int num){
        int cnt=0;
        for(int i=1; i <= Math.sqrt(num); i++){
            if( num % i == 0) {
                cnt+=2;
                if( i*i == num) cnt--;
            }
        }
        return cnt;
    }
    @Test
    void test(){
        Assertions.assertEquals(43,solution(13,17));
    }
}
