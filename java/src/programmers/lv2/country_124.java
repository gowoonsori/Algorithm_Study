package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class country_124 {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder();

        while(n > 0) {
            stringBuilder.insert(0,num[n%3]);
            n =  (n-1)/3;
        }
        answer = stringBuilder.toString();
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals("11",solution(4));
    }
}
