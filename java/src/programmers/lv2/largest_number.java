package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class largest_number {
    public String solution(int[] numbers) {
        String answer;
        Queue<String> q = new PriorityQueue<>((String a,String b) -> (b+a).compareTo(a+b));
        Arrays.stream(numbers).forEach( n -> q.offer(Integer.toString(n)));

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.peek());
            q.poll();
        }
        answer=sb.toString();
        return answer.charAt(0) == '0' ? "0" : answer;
    }
    @Test
    void test(){
        Assertions.assertEquals("6210", solution(new int[]{6,10,2}));
        Assertions.assertEquals("9534330", solution(new int[]{3, 30, 34, 5, 9}));
        Assertions.assertEquals("0", solution(new int[]{0,0,0,0,0}));
    }
}
