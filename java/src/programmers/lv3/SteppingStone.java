package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SteppingStone {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int start = 0;
        int end = 200_000_000;
        while(start < end){
            int mid = (start + end) / 2;
            if(cross(stones,k,mid)) start = mid + 1;
            else end = mid;
        }
        answer = start;
        return answer;
    }

    private boolean cross(int[] stones,int k, int num){
        int cnt=0;
        for(int stone : stones){
            if(stone - num <= 0) cnt++;
            else cnt=0;
            if(cnt >= k) return false;
        }
        return true;
    }
    @Test
    void test1(){
        Assertions.assertEquals(3, solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
    @Test
    void test2(){
        Assertions.assertEquals(1, solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 1));
    }
}
