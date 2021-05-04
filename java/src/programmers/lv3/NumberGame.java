package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int j=0;
        for(int i =0; i < A.length; i++){
            for(; j < B.length;){
                if(A[i] < B[j++]){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(3, solution(new int[]{5,1,3,7}, new int[]{2,2,2,8}));
    }
}
