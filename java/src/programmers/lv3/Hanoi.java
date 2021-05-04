package programmers.lv3;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {
    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        hanoi(1,2,3,n, answer);

        return answer.toArray(int[][]::new);
    }
    private void hanoi(int start,int mid,int end,int n, List<int[]> answer ){
        if(n==0)return;
        hanoi(start,end,mid,n-1,answer);
        answer.add(new int[]{start,end});
        hanoi(mid,start,end,n-1,answer);
    }
}
