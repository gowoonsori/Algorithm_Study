package programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GPS {
    int[][] dp;
    List<List<Integer>> graph = new ArrayList<>();
    private static int INF = 99999999;

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        dp = new int[k][n+1];

        //greaph 초기화
        for(int i=0; i < n+1;i++) graph.add(new ArrayList<>());
        for(int i=0; i < m; i++){
            graph.get(edge_list[i][0]).add(edge_list[i][1]);
            graph.get(edge_list[i][1]).add(edge_list[i][0]);
        }

        //count
        for(int[] arr : dp) Arrays.fill(arr, INF);
        dp[0][gps_log[0]] = 0;

        for(int i=1; i < k; i++){
            for(int j=1; j< n+1; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);

                for(int dest : graph.get(j))
                    dp[i][j] = Math.min(dp[i-1][dest], dp[i][j]);
                dp[i][j] += gps_log[i] == j ? 0 : 1;
            }
        }

        answer = (dp[k-1][gps_log[k-1]] >= INF) ? -1 : dp[k-1][gps_log[k-1]];
        return answer;
    }
}
