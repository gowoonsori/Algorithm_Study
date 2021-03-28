package programmers.skillTest2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class joystick {
    public int solution(String name) {
        int answer = 0;
        int size = name.length();
        char[] c = new char[size]; Arrays.fill(c, 'A');
        StringBuilder tmp = new StringBuilder(String.valueOf(c));

        int idx = 0;
        while (!name.equals(tmp.toString())) {
            tmp.replace(idx, idx + 1, String.valueOf(name.charAt(idx)));
            answer += tmp.charAt(idx) <= 'M' ? tmp.charAt(idx) - 'A' : 'Z' - tmp.charAt(idx) + 1;

            for (int move = 1; move < size; move++) {
                if (name.charAt((idx + move) % size) != tmp.charAt((idx + move) % size)) {
                    answer += move;
                    idx = (idx + move) % size;
                    break;
                } else if (name.charAt((idx + size - move) % size) != tmp.charAt((idx + size - move) % size)) {
                    answer += move;
                    idx = (idx + size - move) % size;
                    break;
                }
            }
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(56, solution("JEROEN"));
    }
}
