package programmers.skillTest2;

import java.util.Arrays;

public class Metrics {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int M = arr1.length;
        int N = arr2[0].length;
        int mid = arr2.length;
        int[][] answer = new int[M][N];

        for(int[] a : answer) Arrays.fill(a,0);
        for(int i=0; i < M; i++){
            for(int j=0; j < N; j++){
                for(int k = 0; k < mid; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
