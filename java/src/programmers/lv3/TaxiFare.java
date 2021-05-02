package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TaxiFare {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        /*floyd*/
        int[][] dist = new int[n+1][n+1];
        for(int i= 0; i <= n; i++) {
            Arrays.fill(dist[i], 100_000_001);
            dist[i][i] = 0;
        }
        for(int[] fare: fares)
            dist[fare[0]][fare[1]] = dist[fare[1]][fare[0]] = fare[2];

        for(int i=1; i <= n; i++)
            for(int j=1; j <= n; j++)
                for(int k=1; k <= n; k++)
                    if(dist[j][k] > dist[j][i] + dist[i][k])
                        dist[j][k] = dist[j][i] + dist[i][k];

        int answer = dist[s][b] + dist[s][a];
        for(int i=1; i<=n; i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }

        return answer;
    }



    @Test
    void test(){
        int[][] fares = new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        Assertions.assertEquals(82,solution(6,4,6,2,fares));
    }
}
