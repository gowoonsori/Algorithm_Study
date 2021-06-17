package baeckjoon.silver;

import java.io.*;
import java.util.Arrays;

public class DrawStar {
    public static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N]; for(char[] arr : map) Arrays.fill(arr,'*');

        draw(0,0, N/3);

        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                bw.write(map[i][j]);
            }
            bw.write('\n');
        }

        br.close();
        bw.close();
    }

    public static void draw(int x, int y,int size){
        drawBlank(x+size,y+size, size);

        if(size == 1) return;
        //위 3개
        draw(x,y,size/3);
        draw(x+size,y,size/3);
        draw(x+size*2,y,size/3);

        //좌우
        draw(x,y+size,size/3);
        draw(x+size*2,y+size,size/3);

        //아래 3개
        draw(x,y+size*2,size/3);
        draw(x+size,y+size*2,size/3);
        draw(x+size*2,y+size*2,size/3);
    }
    public static void drawBlank(int x, int y, int size){
        for(int i=x; i < x+size; i++){
            for(int j=y; j < y+size; j++){
                map[i][j] = ' ';
            }
        }
    }

}
