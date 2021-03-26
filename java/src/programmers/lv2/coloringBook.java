package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int y;
    int x;
    int color;
    Point(int y,int x,int color){this.y = y; this.x = x; this.color = color;}
}

public class coloringBook {
    static int[][] dxy = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] visited = new boolean[101][101];

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        for(boolean[] a : visited) Arrays.fill(a,false);
        for(int i=0; i< m; i++){
            for(int j =0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,bfs(m,n,picture,i,j));
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    int bfs(int m, int n,int[][] picture, int y, int x){
        int count = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y,x,picture[y][x]));
        visited[y][x] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i < 4; i++){
                int nx = p.x + dxy[i][0];
                int ny = p.y + dxy[i][1];
                int color =p.color;
                if(nx >= n  || nx <0 || ny >= m || ny <0)continue;
                if(picture[ny][nx] == color && !visited[ny][nx]){
                    q.offer(new Point(ny,nx,color));
                    visited[ny][nx] = true;
                    count++;
                }
            }
        }
        return count;
    }
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{4,5},solution(6,4,new int[][]{{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},
        {0, 0, 0, 3}}));
    }
}

