package programmers.skillTest3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class hanoi {
    static List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(1,3,2,n);

        int[][] answer = new int[list.size()][2];
        for(int i =0; i < list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
    public void hanoi(int start, int end, int mid, int n){
        if(n == 0)return;

        hanoi(start,mid,end,n-1);
        list.add(new int[]{start,end});
        hanoi(mid,end,start,n-1);
    }
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[][]{{1,2},{1,3},{2,3}}, solution(2));
    }
}
