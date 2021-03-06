package programmers.lv3;

import java.util.Arrays;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];

        for(int i=1; i < size; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];  //가장 왼쪽
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; //가장 오른쪽
            for(int j = 1; j < i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
            }
        }

        return Arrays.stream(dp[size-1]).max().getAsInt();
    }
}
