package programmers.DevMatching_21;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem2 {
    static int[][] dxy =  {{1,0}, {0,1}, {-1,0}, {0, -1}}; //우, 아래, 좌, 위
    static int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        /*make matrix*/
        int cnt = 1;
        matrix = new int[rows][columns];
        for(int i=0; i< rows; i++)
            for(int j=0; j<columns; j++)
                matrix[i][j] = cnt++;


        for(int i =0; i < queries.length; i++){
           answer[i] =  rotate(queries[i][0],queries[i][1],queries[i][2],queries[i][3]);
        }

        return answer;
    }
    public int rotate(int start_row,int start_col, int end_row,int end_col){
        int min=999, x = start_col-1, y= start_row-1;
        int moveCnt =( end_row - start_row ) * 2 + (end_col - start_col) * 2;

        int num =  matrix[y+1][x], curr;
        int move = 0; //0:우, 1:아래, 2:좌, 3:위
        for(int i = moveCnt; i > 0; i--){
            curr = matrix[y][x];
            min = Math.min(min,curr);
            matrix[y][x] = num;
            switch (move){
                case 0:  //오른쪽
                    if(x == end_col-1) move = 1;
                    break;
                case 1:
                    if(y == end_row-1)move = 2;
                    break;
                case 2:
                    if(x == start_col-1)move =3;
                    break;
                case 3:
                    break;
            }
            x += dxy[move][0];
            y += dxy[move][1];
            num = curr;
            matrix[y][x] = curr;
        }
        return min;
    }
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{8, 10, 25},solution(6,6,
                new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}}));
    }
}
