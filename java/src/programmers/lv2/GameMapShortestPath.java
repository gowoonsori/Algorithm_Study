package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x;
    int y;
    int cnt;

    public Pair(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class GameMapShortestPath {
    int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //아래 우 위 좌

    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length, M = maps[0].length;
        boolean[][] visited = new boolean[N][M];

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 1)); visited[0][0] = true;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            if (pair.x == M - 1 && pair.y == N - 1) {
                answer = pair.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dx = pair.x + move[i][0];
                int dy = pair.y + move[i][1];
                if(dx < 0 || dy < 0 || dx >= M || dy >= N )continue;
                if (maps[dy][dx] != 1 || visited[dy][dx]) continue;

                visited[dy][dx] = true;
                q.offer(new Pair(dx, dy, pair.cnt + 1));
            }
        }
        return answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(11, solution(new int[][]{
                {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
        }));
    }
}
