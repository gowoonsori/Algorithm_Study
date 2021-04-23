package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Immigration {
    public long solution(int n, int[] times) {
        long answer=0,avg,min,max;
        Arrays.sort(times);
        min = 0; max =  (long) times[times.length - 1] * n;

        int cnt;
        while (min <= max) {
            avg = (min + max) / 2;
            cnt = 0;
            for(int time : times) cnt += avg/time;

            if(cnt >= n) {
                answer =avg;
                max = avg - 1;
            }
            else min = avg + 1;
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(28, solution(6,new int[]{7,10}));
    }
}
