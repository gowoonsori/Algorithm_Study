package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisitedLength {
    int[][] dxy = {{0,-1}, {0,1}, {1,0}, {-1,0}};
    boolean[][][][] visited = new boolean[11][11][11][11];

    public int solution(String dirs) {
        int answer = 0;

        int x=5,y=5,dx=5,dy=5;
        for(char ch : dirs.toCharArray()){
            if(ch == 'U'){
                dx = x+dxy[0][0];
                dy = y+dxy[0][1];
            }else if(ch == 'D'){
                dx = x+dxy[1][0];
                dy = y+dxy[1][1];
            }else if(ch == 'R'){
                dx = x+dxy[2][0];
                dy = y+dxy[2][1];
            }else{
                dx = x+dxy[3][0];
                dy = y+dxy[3][1];
            }
            if(dx < 0 || dy < 0 || dx > 10 || dy > 10) continue;
            if(visited[x][y][dx][dy]){
                x = dx; y = dy;
                continue;
            }
            visited[x][y][dx][dy] = true;
            visited[dx][dy][x][y] = true;
            x = dx; y = dy;
            answer++;
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(7, solution("ULURRDLLU"));
    }
}
