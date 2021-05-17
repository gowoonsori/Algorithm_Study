package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class Robot{
    int leftX;
    int leftY;
    int rightX;
    int rightY;
    int time;

    public Robot(int leftX, int leftY, int rightX, int rightY, int time) {
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.rightY = rightY;
        this.time = time;
    }
}

public class MoveBlock {
    int[][] dxy = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};  //우,하,좌,상
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;

        boolean[][][][] visited = new boolean[N][N][N][N];
        Queue<Robot> q = new LinkedList<>();
        q.add(new Robot(0,0,1,0,0));
        Robot robot;
        int lx,ly,rx,ry,time,dlx,dly,drx,dry;

        while(!q.isEmpty()) {
            robot = q.poll();
            lx = robot.leftX;
            ly = robot.leftY;
            rx = robot.rightX;
            ry = robot.rightY;
            time = robot.time;
            if ((lx == N - 1 && ly == N - 1) || (rx == N - 1 && ry == N - 1)) {
                answer = time;
                break;
            }
            if (visited[ly][lx][ry][rx] || visited[ry][rx][ly][lx]) continue;
            visited[ly][lx][ry][rx] = visited[ry][rx][ly][lx] = true;

            for(int i=0; i < 4; i++){
                dlx = lx + dxy[i][0];
                dly = ly + dxy[i][1];
                drx = rx + dxy[i][0];
                dry = ry + dxy[i][1];

                if(dlx<0 || dly<0 || dlx>=N || dly>=N || drx<0 || dry<0 || drx>=N || dry>=N) continue; //범위밖 예외처리
                if(visited[dly][dlx][dry][drx] || visited[dry][drx][dly][dlx])continue; //방문했다면 continue
                if(board[dly][dlx] == 1 || board[dry][drx] == 1) continue;              //벽이라면 continue

                //상하좌우 이동
                //수평일때 위아래 이동|수직일때 좌우이동은 한쪽을 중심으로 90도회전후 반대쪽을 중심으로 90도회전한 것과 같다.
                q.add(new Robot(dlx,dly,drx,dry,time+1));
                if((ly == ry && i%2 == 1) || (lx == rx && i%2 ==0)){
                    /*수평이고 위아래이동일때 회전 || 수직이고 좌우이동일때 회전
                    * 수평일때 위아래이동이되거나, 수직일때 좌우이동이 된다는 것은 회전할때 걸리는 벽이 없다.(위에 if에서 걸렀기때문에)*/
                    q.add(new Robot(lx,ly,dlx,dly,time+1));  //왼쪽|위쪽을 중심 회전
                    q.add(new Robot(drx,dry,rx,ry,time+1)); //오른쪽|아래쪽을 중심으로 회전
                }
            }
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(7, solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}}));
    }
}
