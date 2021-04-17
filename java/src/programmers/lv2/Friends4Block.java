package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Friends4Block {
    char[][] map;
    int M,N;
    boolean[][] visited ;
    int answer = 0;

    public int solution(int m, int n, String[] board) {
        M = m; N = n;
        map = new char[M][N];
        visited = new boolean[M][N];

        for(int i =0; i  <M; i++)
            for(int j=0; j < N; j++)
                map[i][j] = board[i].charAt(j);

        while(check()){
            removeBlock();
        }

        return answer;
    }
    private boolean check(){
        for(boolean[] a : visited) Arrays.fill(a,false);
        boolean remove = false;
        for(int i = 0; i < M-1; i++ ){
            for(int j =0; j < N-1; j++){
                if(map[i][j] == '0') continue;
                if(map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i][j] == map[i+1][j+1]){
                    visited[i][j] = visited[i][j+1] = visited[i+1][j] = visited[i+1][j+1] = true;
                    remove = true;
                }
            }
        }
        return remove;
    }
    private void removeBlock(){
        for(int i = 0; i < M; i++ ) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    answer++;
                    for (int k = i - 1; k >= 0; k--) {
                        map[k + 1][j] = map[k][j];
                        map[k][j] = '0';
                    }
                }
            }
        }
    }

    @Test
    void test(){
        Assertions.assertEquals(14, solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }


}
