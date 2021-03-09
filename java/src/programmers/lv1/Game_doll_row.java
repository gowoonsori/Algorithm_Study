package programmers.lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Game_doll_row {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int move : moves){
            for(int i = 0; i < N; i++){
                int item = board[i][move-1];
                board[i][move-1] = 0;

                if( item == 0 ) continue;
                if( stack.peek().equals(item) ) {
                    stack.pop();
                    answer+=2;
                }
                else stack.push(item);
                break;
            }
        }
        return answer;
    }

    @Test
    void 정답(){
        Assertions.assertEquals(4, solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int []{1,5,3,5,1,2,1,4}));
    }
}
