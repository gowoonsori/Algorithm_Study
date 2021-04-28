package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateMatrix {
    int[][] map;
    int[][] dxy = {{1,0},{0,1},{-1,0},{0,-1}}; //Right, Down, Left, Up
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows+1][columns+1];

        /*row x column matirx 만들기*/
        for(int i=1; i <= rows; i++){
            for(int j=1; j <= columns; j++){
                map[i][j] = (i-1)*columns + j;
            }
        }

        /*Rotate와 최소값 찾기*/
        int min,m,n,x,y,tmp,curr;
        for(int i=0; i < queries.length; i++){
            min = Integer.MAX_VALUE;
            x = queries[i][1];
            y = queries[i][0];
            m = queries[i][2] - queries[i][0];
            n = queries[i][3] - queries[i][1];

            /*Right*/
            curr = map[y][x];
            for(int j = 0; j < n; j++){
                x += dxy[0][0];
                y += dxy[0][1];
                tmp = map[y][x];
                min = Math.min(min,tmp);
                map[y][x] = curr;
                curr = tmp;
            }
            /*Down*/
            for(int j = 0; j < m; j++){
                x += dxy[1][0];
                y += dxy[1][1];
                tmp = map[y][x];
                min = Math.min(min,tmp);
                map[y][x] = curr;
                curr = tmp;
            }
            /*Left*/
            for(int j = 0; j < n; j++){
                x += dxy[2][0];
                y += dxy[2][1];
                tmp = map[y][x];
                min = Math.min(min,tmp);
                map[y][x] = curr;
                curr = tmp;
            }
            /*Up*/
            for(int j = 0; j < m; j++){
                x += dxy[3][0];
                y += dxy[3][1];
                tmp = map[y][x];
                min = Math.min(min,tmp);
                map[y][x] = curr;
                curr = tmp;
            }
            answer[i] = min;
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{8,10,25},solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}}));
    }
}
