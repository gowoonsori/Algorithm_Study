package programmers.lv2;

import java.util.Arrays;

public class SaveBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start =0, end = people.length-1;
        Arrays.sort(people);

        int i = 0, j = people.length - 1;
        while(start<=end){
            if(people[start] + people[end] <= limit) start++;
            end--;
            answer++;
        }

        return answer;
    }
}
