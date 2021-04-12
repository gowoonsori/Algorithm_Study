package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JadenCase {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] arr = s.toLowerCase().toCharArray();

        boolean isFirst = true;
        for(char ch : arr){
            if(isFirst && ch >= 'a') answer.append((char)(ch - 32));
            else answer.append(ch);
            isFirst = ch == ' ';
        }
        return answer.toString();
    }

    @Test
    void test(){
        Assertions.assertEquals("3people A Me", solution("3people a me"));
    }
}