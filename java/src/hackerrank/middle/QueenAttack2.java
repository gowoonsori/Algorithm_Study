package hackerrank.middle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueenAttack2 {
    public int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int result=0;
        int up=n+1,down=0, left=0, right=n+1, rightUp = n+1, leftUp = n+1, rightDown = 0, leftDown = 0;

        int size = obstacles.size();
        for(int i=0; i < size; i++){
            int y = obstacles.get(i).get(0);
            int x = obstacles.get(i).get(1);

            //same row
            if(y == r_q){
                if(x> c_q) right = Math.min(right,x);   //right
                else left = Math.max(left,x);           //left
            }
            //same col
            else if(x == c_q){
                if( y > r_q) up = Math.min(up,y);   //up
                else down = Math.max(down,y);       //down
            }
            //11->5 diagonal
            else if(r_q + c_q == x+y){
                if(y>r_q) leftUp = Math.min(leftUp,y);      //leftUp
                else rightDown = Math.max(rightDown,y);    //right down
            }
            //1->7 diagonal
            else if(r_q - c_q == y-x){
                if(y > r_q) rightUp = Math.min(rightUp,y);
                else leftDown = Math.max(leftDown,y);
            }
        }
        result += (right - c_q -1);
        result += (c_q -left -1);
        result += (up - r_q -1);
        result += (r_q - down -1);
        result += Math.min(c_q - 1, leftUp - r_q - 1);
        result += Math.min(c_q - 1, r_q - leftDown - 1);
        result += Math.min(n - c_q, r_q - rightDown - 1);
        result += Math.min(n - c_q, rightUp - r_q - 1);

        return result;
    }
    @Test
    void test(){
        int[][] obstacles = new int[][]{
                {5,5},{4,2},{2,3}};

        Assertions.assertEquals(10, queensAttack(5,3,4,3,
                Arrays.stream(obstacles).map(arr -> Arrays.stream(arr)
                .boxed().collect(Collectors.toList())).collect(Collectors.toList())));
    }
}
