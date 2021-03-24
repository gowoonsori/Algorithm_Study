package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max = maxPrority(priorities);
        while(true) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == max) {
                    answer++;
                    if (i == location) return answer;
                    priorities[i] = 0;
                    max = maxPrority(priorities);
                }
            }
        }
    }

    int maxPrority(int[] priorities){
        int max = 0;
        for(int v : priorities){
            max = Math.max(max,v);
        }
        return max;
    }

    @Test
    void test(){
        Assertions.assertEquals(1, solution(new int[]{2,1,3,2}, 2));
    }
}
