package goorm.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ImageProcessing {
    public static class Pixel{
        int x;
        int y;

        public Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}}; //R, L, D, U
    static int N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int cnt=0,size=0;
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i < M; i++){
            input = br.readLine().split("");
            for(int j =0; j < N; j++){
                if(!input[j].equals("#")) visited[i][j] = true;
            }
        }

        for(int i=0; i < M; i++){
            for(int j =0; j < N; j++){
                if(!visited[i][j]){
                    cnt++;
                    size = Math.max(size,calculateSize(i,j));
                }
            }
        }
        System.out.println(cnt);
        System.out.println(size);
    }
    static int calculateSize(int row,int col){
        int size=1;
        Queue<Pixel> q = new LinkedList<>();
        q.add(new Pixel(col,row)); visited[row][col] = true;

        Pixel p;
        int dx,dy;
        while(!q.isEmpty()){
            p = q.poll();

            for(int i=0; i < 4; i++){
                dx = p.x + dxy[i][0];
                dy = p.y + dxy[i][1];

                if(dx < 0 || dy <0 || dx >= N || dy >= M) continue;
                if(visited[dy][dx])continue;
                q.add(new Pixel(dx,dy));
                visited[dy][dx] = true;
                size++;
            }
        }
        return size;
    }
}
