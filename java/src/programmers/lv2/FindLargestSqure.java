package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindLargestSqure {
    public int solution(int[][] board) {
        int answer = 1;
        boolean isZero = Arrays.stream(board).allMatch(ints -> Arrays.stream(ints).allMatch(num -> num == 0));
        if(isZero)return 0;

        for(int i=1; i < board.length; i++ ){
            for(int j=1; j < board[0].length; j++){
                if(board[i][j] == 1 && board[i-1][j-1] > 0){
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    if(board[i][j] > answer) answer = board[i][j];
                }
            }
        }

        return answer * answer;
    }
    @Test
    void test(){
        //Assertions.assertEquals(9, solution(new int[][]{ {0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
        Assertions.assertEquals(4, solution(new int[][]{ {0,0,1,1},{1,1,1,1}}));
        //Assertions.assertEquals(16, solution(new int[][]{ {1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}}));
    }
}
