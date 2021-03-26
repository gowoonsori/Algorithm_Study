package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class triangle_snail {
    enum STATE {DOWN, RIGHT, UP}

    public int[] solution(int n) {
        int[] answer = new int[n *(n+1)/2];
        int[][] snail = new int[n][n];

        STATE state = STATE.DOWN;
        int x = 0, y = -1, cnt = 1;
        for (int i = 0; i <= n; i++) {
            for(int j=i; j < n; j++){
                if(state == STATE.DOWN) y++;
                else if(state == STATE.RIGHT) x++;
                else {y--;x--;}
                snail[y][x] = cnt++;
            }
            if(state == STATE.DOWN) state = STATE.RIGHT;
            else if(state == STATE.RIGHT) state = STATE.UP;
            else state = STATE.DOWN;
        }

        int k=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (snail[i][j] == 0) break;
                answer[k++]=snail[i][j];
            }
        }
        return answer;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1, 2, 9, 3, 10, 8, 4, 5, 6, 7},solution(4));
    }
}
