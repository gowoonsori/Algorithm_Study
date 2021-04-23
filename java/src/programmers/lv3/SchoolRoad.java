package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SchoolRoad {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        dp[0][1] = 1;
        for(int i=1; i <= n; i++){
            for(int j=1; j <= m; j++){
                if(dp[i][j] == -1 ) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;
            }
        }
        return dp[n][m];
    }
    @Test
    void test(){
        Assertions.assertEquals(0, solution(2, 2, new int[][]{{2,1}, {1, 2}}));
    }
    @Test
    void test1(){
        Assertions.assertEquals(7, solution(4, 4, new int[][]{{3,2}, {2,4}}));
    }
}
