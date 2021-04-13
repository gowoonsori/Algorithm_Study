package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GCD_N {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i< arr.length; i++ ){
            answer = lcd(Math.max(answer,arr[i]),Math.min(answer,arr[i]));
        }
        return answer;
    }

    private int lcd(int a, int b){
        return a*b / gcd(a,b);
    }

    private int gcd(int a, int b){
        int c;
        while(b > 0){
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    @Test
    void test(){
        Assertions.assertEquals(168, solution(new int[]{2,6,8,14}));
    }
}
