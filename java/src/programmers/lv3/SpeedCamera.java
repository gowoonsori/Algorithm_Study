package programmers.lv3;

import java.util.*;

public class SpeedCamera {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(o1,o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[1];
        });

        int camera = Integer.MIN_VALUE;
        for(int[] route : routes){
            if(camera < route[0]){
                answer++;
                camera = route[1];
            }
        }
        return answer;
    }
}
