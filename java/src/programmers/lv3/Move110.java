package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Move110 {
    public String[] solution(String[] s) {
        int N = s.length;
        String[] answer = new String[N];
        Stack<Character> stack = new Stack<>();
        int cnt;

        String str;
        char x, y, z;
        for (int i = 0; i < N; i++) {
            str = s[i];
            stack.clear();
            cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                z = str.charAt(j);
                if (stack.size() < 2) {
                    stack.push(z);
                    continue;
                }

                y = stack.pop();
                x = stack.pop();
                if (x == '1' && y == '1' && z == '0' ) {
                    cnt++;
                    continue;
                }

                stack.push(x);
                stack.push(y);
                stack.push(z);
            }

            if (cnt < 1) {
                answer[i] = s[i];
                continue;
            }

            int index = stack.size();
            StringBuilder sb = new StringBuilder();
            boolean isZero = false;
            while (!stack.isEmpty()) {
                if (!isZero && stack.peek() == '1' ) index--;
                if (!isZero && stack.peek() == '0' ) isZero = true;
                sb.insert(0, stack.pop());
            }
            while (cnt > 0) {
                sb.insert(index, "110");
                cnt--;
            }
            answer[i] = sb.toString();
        }
        return answer;
    }


    @Test
    void test(){
        Assertions.assertArrayEquals(new String[]{"1101", "100110110", "0110110111"},
                solution(new String[]{"1110", "100111100", "0111111010"}));
    }
}
