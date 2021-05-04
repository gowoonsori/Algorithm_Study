package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class WorkOverNight {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) q.add(work);

        for(int i=n; i > 0 ;i--){
            if(q.isEmpty()) break;
            int work = q.poll() - 1;
            if(work > 0) q.add(work);
        }

        while(!q.isEmpty()){
            int work = q.poll();
            answer += Math.pow(work,2);
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(12,solution(4, new int[]{4,3,3}));
    }
}
