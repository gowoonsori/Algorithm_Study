package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Edge{
    int dest;
    int cost;

    public Edge(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

public class Deilvery {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        /*인접 리스트 생성*/
        List<List<Edge>> edgeList = new ArrayList<>();
        for(int i=0; i <= N; i++)edgeList.add(new ArrayList<>());
        for(int i=0; i < road.length; i++){
            edgeList.get(road[i][0]).add(new Edge(road[i][1], road[i][2]));
            edgeList.get(road[i][1]).add(new Edge(road[i][0], road[i][2]));
        }

        /*prim 알고리즘 이용*/
        int[] dp = new int[N+1]; Arrays.fill(dp,Integer.MAX_VALUE); dp[1]=0;
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        q.offer(new Edge(1,0));
        while(!q.isEmpty()){
            Edge currentEdge = q.poll();

            for(Edge e : edgeList.get(currentEdge.dest)){
                if((dp[e.dest] > e.cost + dp[currentEdge.dest])){
                    q.offer(e);
                    dp[e.dest]  = e.cost + dp[currentEdge.dest];
                }
            }
        }
        for(int dist : dp) if(dist <= K) answer++;
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(4, solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
    }
}
