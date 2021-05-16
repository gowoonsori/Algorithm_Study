package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HowToLine {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        k--;
        for (int i = 0; n > 0; i++, n--) {
            factorial /= n;
            answer[i] = list.get((int) (k / factorial));
            list.remove((int) (k / factorial));
            k %= factorial;
        }

        return answer;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{3, 1, 2}, solution(3, 5));
    }
}
