package programmers.skillTest3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class longest_node {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        //인접 리스트 생성
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++) list.add(new ArrayList<>());
        for(int[] node:edge){
            list.get(node[0]).add(node[1]);
            list.get(node[1]).add(node[0]);
        }

        int[] count = new int[n+1];  //노드별 depth count
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[0]=visited[1]=true;
        int now;
        while(!q.isEmpty()){
            now=q.poll();
            for(int v:list.get(now)){
                if(!visited[v]){
                    count[v]=count[now]+1;
                    visited[v]=true;
                    q.add(v);
                }
            }
        }

        int max=0;
        for(int cnt:count){
            if(max<cnt){
                max=cnt;
                answer=1;
            }
            else if(max==cnt) answer++;
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(3, solution(6,new int[][]{{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2}}));
    }
}
