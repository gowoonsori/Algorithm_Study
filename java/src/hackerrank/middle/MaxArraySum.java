package hackerrank.middle;

import java.util.Arrays;

public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    int[] dp;
    int N;

    int maxSubsetSum(int[] arr) {
        int N = arr.length;
        int[] dp = new int[N+1];
        dp[0] = -10001; dp[1] = arr[0]; dp[2] = arr[1];

        int max;
        for (int i = 2; i < N; i++){
            max = Math.max(dp[i-1],dp[i-2]);
            if(arr[i] < 0 ) dp[i+1] = max;
            else dp[i+1] = Math.max(arr[i], max+arr[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }


}
