package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NQueen {
    int N;
    int[] position;
    int answer = 0;

    public int solution(int n) {
        N = n;
        position = new int[n];

        queen(0);
        return answer;
    }
    public void queen(int dep){
        if(dep == N){
            answer++;
            return;
        }
        for(int i=0; i < N; i++){
            position[dep] = i;
            if(possible(dep)){
                queen(dep+1);
            }
        }
    }
    public boolean possible(int row){
        for(int i=0; i < row; i++){
            /*직선 => 한 row에 한개만 들어가기 때문에 col만 확인하면된다.*/
            if(position[i] == position[row])return false;
            /*대각선*/
            if(row - i == Math.abs(position[row] - position[i])) return false;
        }
        return true;
    }
    @Test
    void test(){
        Assertions.assertEquals(2,solution(4));
    }
}
