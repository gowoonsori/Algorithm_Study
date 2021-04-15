package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class WordPlay {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();

        int len = words.length;
        int idx;
        set.add(words[0]);
        for(idx=1; idx < len; idx++){
            if(words[idx].charAt(0) != words[idx-1].charAt(words[idx-1].length()-1) || set.contains(words[idx])){
                answer[0] = idx%n + 1;
                answer[1] = (idx)/n + 1;
                break;
            }
            else set.add(words[idx]);
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{3,3}, solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
    }

    @Test
    void test2(){
        Assertions.assertArrayEquals(new int[]{1,3}, solution(2,new String[]{"hello", "one", "even", "never", "now", "world", "draw"}));
    }
}
