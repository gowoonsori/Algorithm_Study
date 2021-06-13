package hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AcmIcpcTeam {
    public List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        int N = topic.size();
        int[] answer = new int[2];

        int bitCnt;
        for(int i =0; i < N; i++){
            for(int j=i+1; j < N; j++){
                bitCnt = countBitOr(topic.get(i),topic.get(j));

                if(answer[0] < bitCnt ){
                    answer[0] = bitCnt;
                    answer[1] = 1;
                }else if(answer[0] == bitCnt) answer[1]++;
            }
        }
        return Arrays.stream(answer).boxed().collect(Collectors.toList());
    }
    int countBitOr(String s1, String s2){
        int N = s1.length();
        int cnt = 0;

        for(int i=0; i < N; i++){
            if(s1.charAt(i) == '1' || s2.charAt(i) == '1') cnt++;
        }

        return cnt;
    }

    @Test
    void test(){
        acmTeam(Arrays.asList("10101","11100","11010","00101"));
    }
}
