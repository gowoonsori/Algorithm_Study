package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MakeAll0 {
    long answer = 0;
    boolean[] visited;
    long[] weights;
    ArrayList<Integer>[] tree;

    public long solution(int[] a, int[][] edges) {
        visited = new boolean[a.length];
        weights = new long[a.length];
        tree = new ArrayList[a.length];

        /*check*/
        int sum=0;
        boolean isZero = true;
        for(int i=0; i < a.length; i++) {
            if(a[i] != 0) isZero = false;
            sum += a[i];
            weights[i] = a[i];
            tree[i] = new ArrayList<>();
        }
        if(isZero) return 0;        //모두 0이라면 return 0
        else if(sum!=0) return -1;  //가중치를 0으로 만들 수 없다면 return -1

        /*인접 리스트 생성*/
        for(int i=0; i < edges.length; i++){
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }

        /*dfs*/
        dfs(0);

        return answer;
    }
    private long dfs(int vertex){
        visited[vertex] = true;

        for(int i=0; i < tree[vertex].size(); i++){
            int next = tree[vertex].get(i);
            if(!visited[next]){
                weights[vertex] += dfs(next);
            }
        }
        answer += Math.abs(weights[vertex]);
        return weights[vertex];
    }

    @Test
    void test(){
        Assertions.assertEquals(9, solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
    }
}
