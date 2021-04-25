package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ConnectIsland {
    int[] set;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        set = new int[n];
        Arrays.sort(costs,(o1,o2) -> o1[2] - o2[2]);
        for(int i=0; i < n; i++) set[i] = i;

        for(int i = 0; i < costs.length; i++){
            if(union(Math.min(costs[i][0], costs[i][1]), Math.max(costs[i][0], costs[i][1]))){
                answer += costs[i][2];
            }
        }
        return answer;
    }
    private boolean union(int start,int end){
        int x = find(start);
        int y = find(end);
        if(x==y) return false;

        set[y] = x;
        return true;
    }

    private int find(int start){
        if(set[start] != start) return set[start] =  find(set[start]);
        return start;
    }
    @Test
    void test(){
        Assertions.assertEquals(11, solution(6,new int[][]{{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}}));
    }
}
