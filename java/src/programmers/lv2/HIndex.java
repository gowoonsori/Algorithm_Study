package programmers.lv2;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(c, Collections.reverseOrder());
       if(c[0] == 0) return answer;
       for(int i=0; i < c.length; i++){
           if(c[i] > i) answer++;
           else break;
       }
        return answer;
    }
}
