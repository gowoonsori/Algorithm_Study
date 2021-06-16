package baeckjoon;

import java.util.Scanner;

public class RobotCleaner {
    public static final Scanner sc = new Scanner(System.in);
    static int N,M;
    static int[][] map;
    static int[][] dxy = {{0,-1},{1,0},{0,1},{-1,0}}; //U R D L
    static int cnt=0;

    public static void main(String[] args) {
        /* init */
        N = sc.nextInt(); M = sc.nextInt();
        int startY = sc.nextInt();
        int startX = sc.nextInt();
        int dir = sc.nextInt();
        map = new int[N][M];

        for(int i=0; i < N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        /* solution */
        dfs(startX, startY, dir);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int dir){
        if( map[y][x] == 0 ){
            map[y][x] = 2;
            cnt++;
        }

        boolean notClean = true;
        int nx,ny,nDr;
        for(int i=0; i < 4; i++){
            nDr = ( dir + 3 ) % 4;
            nx = x + dxy[nDr][0];
            ny = y + dxy[nDr][1];
            dir  = (dir +3) % 4;

            if( nx < 0 || ny < 0|| nx >= M || ny >= N || map[ny][nx] == 1 || map[ny][nx] == 2) continue;
            dfs(nx,ny,nDr);
            notClean = false;
            break;
        }

        if(notClean){
            nDr = ( dir + 2 ) % 4;
            nx = x + dxy[nDr][0];
            ny = y + dxy[nDr][1];

            if( nx < 0 || ny < 0|| nx >= M || ny >= N || map[ny][nx] == 1 ) return;
            dfs(nx,ny,dir);
        }

    }
}
