package programmers.lv2;

public class MultipleMatrix {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int N = arr1.length;
        int M = arr2[0].length;
        int K = arr2.length;
        int[][] answer = new int[N][M];

        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                for(int k = 0; k < K; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
