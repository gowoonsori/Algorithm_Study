package scofe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
입력
4 5
c.xc
....
xx..
...x
x..x

출력
1
* */

class StartPoint {
    int x;
    int y;

    public StartPoint(int x, int y) {this.x = x; this.y = y;}
}

public class Lightning {
    static int N, M;
    static List<StartPoint> starts = new ArrayList<>();
    static int[][] map = new int[1001][21];
    static boolean[][] visited = new boolean[1001][21];
    static int dxy[][] = {{0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt(); scanner.nextLine();

        for(int[] a: map) Arrays.fill(a,-1);

        for (int i = 0; i < M; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if (c == 'x') map[i][j] = 1;
                else if (c == 'c') {
                    starts.add(new StartPoint(j, i));
                    map[i][j] = 1;
                } else map[i][j] = 0;
            }
        }

        /*solution*/
        int answer = 9999;
        for (StartPoint s : starts) {
            for (boolean[] a : visited) Arrays.fill(a, false);

            int sx = s.x;
            int sy = s.y;
            answer = Math.min(answer, solution(sx, sy, 0));
        }
        System.out.println(answer);
    }

    static int solution(int x, int y, int move) {
        if (y == M) return move;
        if(map[y][x] != 0) return 9999;

        int result = 9999;
        for (int i = 0; i < 3; i++) {
            int nx = x + dxy[i][0];
            int ny = y + dxy[i][1];
            if (!visited[ny][nx] && (nx >= 0 && nx < N)) {
                if (i != 0) move++;
                visited[ny][nx] = true;
                result = Math.min(result, solution(nx, ny, move));
                visited[ny][nx] = false;
            }
        }
        return move;
    }
}
