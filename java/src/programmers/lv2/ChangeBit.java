package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeBit {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int tmp_length;

        while(!s.equals("1")) {
           answer[0]++;
           tmp_length = removeZero(s);
           answer[1] += s.length() - tmp_length;
           //s = Integer.toBinaryString(tmp_length);
        }
        return answer;
    }
    private String change(int num){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num % 2);
            num /= 2;
        }
        return sb.toString();
    }

    private int removeZero(String s){
        String tmp = s.replaceAll("0","");
        return tmp.length();
    }
    @Test
    void test1(){
        Assertions.assertArrayEquals(new int[]{3,8}, solution("110010101001"));
    }
    @Test
    void test2(){
        Assertions.assertArrayEquals(new int[]{3,3}, solution("01110"));
    }
}
