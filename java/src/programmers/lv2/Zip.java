package programmers.lv2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Zip {
    List<String> dictionary;
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        initDictionary();

        int size = msg.length();
        StringBuilder word = new StringBuilder();
        int max_order = 0;
        for(int i=0; i < size; i++){
            word.append( msg.charAt(i)) ;
            if(dictionary.contains(word.toString())) {
                max_order = dictionary.indexOf(word.toString());
                continue;
            }
            i--;
            answer.add(max_order);
            dictionary.add(word.toString());
            word.setLength(0);
        }
        answer.add(max_order);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    private void initDictionary(){
        dictionary = new ArrayList<>();
        dictionary.add("");
        for(int i=0; i < 26; i++){
            char ch = (char)(i + 'A');
            dictionary.add(String.valueOf(ch));
        }
    }
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{11,1,27,15}, solution("KAKAO"));
    }
}
