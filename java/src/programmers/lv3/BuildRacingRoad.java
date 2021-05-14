package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class Road {
    int x;
    int y;
    int cost;
    int direction;   //-1: X | 0: R | 1: L | 2: U | D: 3

    public Road(int x, int y, int cost, int direction) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.direction = direction;
    }
}

public class BuildRacingRoad {
    int[][] dxy = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; //R, L, U, D

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;

        Queue<Road> q = new LinkedList<>();
        q.add(new Road(0, 0, 0, -1));

        int dx, dy,dcost;
        while (!q.isEmpty()) {
            Road road = q.poll();
            int x = road.x;
            int y = road.y;
            int cost = road.cost;
            int dir = road.direction;

            if (x == n - 1 && y == n - 1) {
                answer = Math.min(answer, cost);
            }

            for (int i = 0; i < 4; i++) {
                dx = x + dxy[i][0];
                dy = y + dxy[i][1];
                dcost = cost;
                if (dx < 0 || dx >= n || dy < 0 || dy >= n || board[dy][dx] == 1) continue;
                /*도로가 코너인지 직선인지 check*/
                if (dir == -1 || dir == i) dcost += 100;
                else dcost += 600;

                /*처음 도로를 짓거나 최소비용일때만 queue에 삽입*/
                if (board[dy][dx] != 0 && board[dy][dx] < dcost) continue;
                board[dy][dx] = dcost;
                q.add(new Road(dx, dy, dcost, i));
            }
        }
        return answer;
    }
    @Test
    void test(){
        int[][] a = new int[][]{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        Assertions.assertEquals(3800, solution(a));
    }
}
