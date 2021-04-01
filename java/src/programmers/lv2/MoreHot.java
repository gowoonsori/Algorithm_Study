package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MoreHot {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        while(q.peek() < K){
            if(q.size() == 1) return -1;
            int food1 = q.poll();
            int food2 = q.poll();
            int newFood = food1 + food2 * 2;
            q.add(newFood); answer++;
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(2, solution(new int[]{1, 2, 3, 9, 10, 12},7));
    }
}
