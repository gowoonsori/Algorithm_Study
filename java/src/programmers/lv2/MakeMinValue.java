package programmers.lv2;

import java.util.Arrays;

public class MakeMinValue {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int size =A.length;
        for(int i = 0; i < size; i++){
            answer += A[i] * B[size-i-1];
        }
        return answer;
    }
}
