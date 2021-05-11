package programmers.lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecommendNewId {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        //1,2,3 단계
        answer.append(new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "").replaceAll("\\.{2,}", "."));

        //4단계
        if (answer.length() > 0 && answer.charAt(0) == '.') answer.deleteCharAt(0);
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') answer.deleteCharAt(answer.length() - 1);

        //5단계
        if (answer.length() < 1) answer.append('a');

        //6단계
        if (answer.length() >= 16) answer.delete(15, answer.length());
        if (answer.charAt(answer.length() - 1) == '.') answer.deleteCharAt(answer.length() - 1);

        //7단계
        if (answer.length() <= 2) {
            char ch = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer.append(ch);
            }
        }

        return answer.toString();
    }

    @Test
    void test1() {
        Assertions.assertEquals("bat.y.abcdefghi", solution("...!@BaT#*..y.abcdefghijklm"));
    }

    @Test
    void test2() {
        Assertions.assertEquals("z--", solution("z-+.^."));
    }

    @Test
    void test3() {
        Assertions.assertEquals("abcdefghijklmn", solution("abcdefghijklmn.p"));
    }

    @Test
    void test4() {
        Assertions.assertEquals("aaa", solution("*"));
    }
}
