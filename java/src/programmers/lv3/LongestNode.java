package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int num;
    int distance;

    public Node(int num,int distance) {
        this.num = num;
        this.distance = distance;
    }


}

public class LongestNode {
    List<List<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dis = new int[n];
        boolean[] visited = new boolean[n+1];

        /*인접 리스트 작성*/
        for(int i=0; i <= n; i++)list.add(new ArrayList<>());
        for(int[] e : edge){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        /*BFS로 모든 노드 방문*/
        Queue<Node> q = new LinkedList<>();
        visited[1] = true; q.add(new Node(1,0));
        while(!q.isEmpty()){
            Node node = q.poll();
            dis[node.distance]++;

            for(int i =0; i <list.get(node.num).size(); i++){
                int dest = list.get(node.num).get(i);
                if(visited[dest])continue;
                q.add(new Node(dest, node.distance+1));
                visited[dest] = true;
            }
        }

        for(int i = n-1; i >=0; i--){
            if(dis[i] != 0) {
                answer = dis[i];
                break;
            }
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(3, solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
