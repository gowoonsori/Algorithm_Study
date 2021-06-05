package programmers.lv5;

import java.util.ArrayList;
import java.util.List;

public class GravityEffect {

    class Node{
        int index;
        long value;
        long childSum;
        List<Node> childs = new ArrayList<>();

        public Node(int index,long value, long childSum) {
            this.index = index;
            this.value = value;
            this.childSum = childSum;
        }

    }

    public long[] solution(int[] values, int[][] edges, int[][] queries) {
        int N = values.length;
        long[] answer = new long[queries.length];

        Node[] nodes = new Node[N];
        for(int i=0; i<= N; i++) nodes[i] = new Node(i,values[i],0);


        Node root = nodes[0];






        return answer;
    }
}
