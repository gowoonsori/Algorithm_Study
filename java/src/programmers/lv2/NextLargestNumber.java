package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NextLargestNumber {
    public int solution(int n) {
        int answer = 0;
        int cnt = calculate(n);

        while(true){
            if(cnt == calculate(++n))return n;
        }
    }
    public int calculate(int n){
        int cnt = 0;
        for(int i = 1; i < n; i*=2){
            if((n&i) == i) cnt++;
        }
        return cnt;
    }
    @Test
    void test(){
        Assertions.assertEquals(83,solution(78));
    }
}
