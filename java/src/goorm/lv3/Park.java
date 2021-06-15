package goorm.lv3;

import java.util.Scanner;

public class Park {
    public static final Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseIndex) {
        int N = scanner.nextInt();  // 지도의 크기
        int K = scanner.nextInt();  // 놀이공원의 크기
        int answer = Integer.MAX_VALUE;

        int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부
        for (int r = 0; r < N; r += 1) {
            for (int c = 0; c < N; c += 1) {
                wastes[r][c] = scanner.nextInt();
            }
        }

        for(int i=0; i <= N-K; i++){
            for(int j=0; j <= N-K; j++){
                answer = Math.min(answer, calulateTrash(wastes,i,j,N,K));
            }
        }
        System.out.println(answer);
    }
    public static int calulateTrash(int[][] wastes, int col, int row,int N, int K){
        int sum = 0;
        for(int i=row; i < row+K; i++  ){
            for(int j=col; j < col+K; j++){
                if(wastes[i][j] == 1) sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }

    }
}
