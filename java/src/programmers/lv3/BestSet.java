package programmers.lv3;

import java.util.Arrays;

public class BestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n > s) return new int[]{-1};
        Arrays.fill(answer, s/n);

        int last = s%n;
        for(int i=0; i < last; i++){
            answer[n-i-1]++;
        }
        return answer;
    }
}
