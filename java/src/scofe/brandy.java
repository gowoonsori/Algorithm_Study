package scofe;

import java.util.Scanner;

public class brandy {
    static int N,M;
    static int map[][] = new int[10001][101];
    static int dp[][] = new int[10001][101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        for(int i=0; i < M; i ++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                dp[i][j] = map[i][j];
            }
        }

        /*solution*/
        for(int i=0; i < M; i ++) {
            if(i != 0 )dp[i][0] += dp[i-1][0];
            for (int j = 1; j < N; j++) {
                if(i==0) dp[i][j] += dp[i][j-1];
                else dp[i][j] += Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println(dp[M-1][N-1]);
    }
}
