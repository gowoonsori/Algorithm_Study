package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WalkerHeaven {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] dp = new int[m+1][n+1][2];  //3번째 0 -> 우회전, 1-> 아래

        dp[1][1][0] = dp[1][1][1] = 1;
        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(cityMap[i-1][j-1] == 0){
                    dp[i][j][0] += (dp[i-1][j][1] + dp[i][j-1][0] ) % MOD;
                    dp[i][j][1] += (dp[i-1][j][1] + dp[i][j-1][0] ) % MOD;
                }else if(cityMap[i-1][j-1] == 2){
                    dp[i][j][0] = dp[i][j-1][0];
                    dp[i][j][1] = dp[i-1][j][1];
                }
            }
        }
        answer = dp[m][n][0];
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(6, solution(3,3,new int[][]{{0, 0, 0},{ 0, 0, 0},{ 0, 0, 0}}));
    }
}
