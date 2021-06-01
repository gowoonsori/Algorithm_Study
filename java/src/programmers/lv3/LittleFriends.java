package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LittleFriends {
    class Tile{
        int y;
        int x;
        int dir;    //-1: 시작 | 0: R | 1: D | 2: L
        char name;

        public Tile(int y, int x, int dir, char name) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.name = name;
        }
    }

    int[][] dxy = new int[][]{{1,0},{0,1},{-1,0}}; // R D L
    int M,N;
    public String solution(int m, int n, String[] board) {
        String answer = "IMPOSSIBLE";
        StringBuilder sb = new StringBuilder();
        Map<Character,Tile> tileMap = new TreeMap<>();
        M = m;N = n;

        /*나오는 tile 종류 check*/
        for(int i=0; i < M; i++){
            for(int j=0; j < N; j++){
                if( !(board[i].charAt(j) == '.' || board[i].charAt(j) == '*'))
                    tileMap.putIfAbsent(board[i].charAt(j),new Tile(i,j,-1,board[i].charAt(j)));
            }
        }

        boolean isDone = true;
        char result = 0;
        while(isDone && !tileMap.isEmpty()){
            isDone = false;

            for(Tile tile : tileMap.values()){
                result = findPair(board,tile.y,tile.x);     //짝을 못지운다면 0반환
                if(result != 0) {
                    sb.append(result);
                    isDone = true;
                    break;
                }
            }
            if(isDone) tileMap.remove(result);
        }

        return tileMap.isEmpty() ? sb.toString() : answer;
    }
    private char findPair(String[] board,int y, int x){
        char target = board[y].charAt(x);
        char result = 0;

        /*BFS를 위한 변수*/
        int[][] turnCnt = new int[M][N];
        Queue<Tile> q = new LinkedList<>();
        q.add(new Tile(y,x,-1,target));
        int dx,dy,nextDir,nextTurnCnt;
        Tile tile;

        /*BFS 시작*/
        while(!q.isEmpty()){
            tile = q.poll();

            //처음이아니고 target과 같다면
            if(tile.name == target && (tile.y != y || tile.x != x)){
                result = target;
                board[tile.y] = board[tile.y].replace(target,'.');  //짝 없애기
                board[y] = board[y].replace(target,'.');            //짝 없애기
                break;
            }

            for(int i=0; i < 3; i++){
                dx = tile.x +dxy[i][0];
                dy = tile.y+dxy[i][1];
                nextDir = i;
                nextTurnCnt = turnCnt[tile.y][tile.x];
                if(tile.dir != -1 && tile.dir != nextDir) nextTurnCnt++;

                if(dy < 0 || dx < 0 || dy >= M || dx>=N) continue;
                if(nextTurnCnt >= 2) continue;
                if(board[dy].charAt(dx) != '.' && board[dy].charAt(dx) != target) continue;
                q.add(new Tile(dy,dx,i,board[dy].charAt(dx)));
                turnCnt[dy][dx] = nextTurnCnt;
            }
        }
        return result;
    }

    @Test
    void test1(){
        Assertions.assertEquals("ABCD", solution(3,3, new String[]{"DBA", "C*A", "CDB"}));
    }

    @Test
    void test2(){
        Assertions.assertEquals(	"MUZI", solution(4,4, new String[]{".ZI.", "M.**", "MZU.", ".IU."}));
    }
    @Test
    void test3(){
        Assertions.assertEquals(	"ABCDFHGIE", solution(5,5, new String[]{ "FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE"}));
    }
    @Test
    void test5(){
        Assertions.assertEquals(	"IMPOSSIBLE", solution(5,5, new String[]{ "*F***", "*..**", "**.**", "**.**", "**F**"}));
    }
}
