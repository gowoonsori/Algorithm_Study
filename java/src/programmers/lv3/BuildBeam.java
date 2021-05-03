package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildBeam {
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> answer = new ArrayList<>();
        int[][] map = new int[n+1][n+1]; // -1: 설치x | 0 : 기둥 | 1 : 보 | 2: 둘다
        for(int[] a:map) Arrays.fill(a,-1);

        for(int[] frame : build_frame){
            int x = frame[0];
            int y = frame[1];
            if(frame[3] == 1){
                if(frame[2] == 0){
                    /*기둥 설치*/
                    if(isBuildPillar(x, y,map)){
                        if(map[y][x] == -1) map[y][x] = 0;
                        else map[y][x] = 2;
                    }
                }else{
                    /*보 설치*/
                    if(isBuildBeam(x,y,map)){
                        if(map[y][x] == -1) map[y][x] = 1;
                        else map[y][x] = 2;
                    }
                }
            }else{
             /*삭제*/
                int[][] tmp = new int[n+1][n+1];
                for(int i=0; i <= n; i++) System.arraycopy(map[i],0,tmp[i],0,n+1);
                if(frame[2] == 0) tmp[y][x] -= 1;
                else tmp[y][x] -= 2;
                if(check(tmp)){
                    for(int i=0; i <= n; i++) System.arraycopy(tmp[i],0,map[i],0,n+1);
                }
            }
        }

        for(int i=0; i <= n; i++){
            for(int j=0; j <= n; j++){
                if(map[j][i] == 2){
                    answer.add(new int[]{i,j,0});
                    answer.add(new int[]{i,j,1});
                }else if(map[j][i] == 1) answer.add(new int[]{i,j,1});
                else if(map[j][i] == 0) answer.add(new int[]{i,j,0});
            }
        }

        return answer.toArray(int[][]::new);
    }
    private boolean check(int[][] tmp){
        for(int i=0; i < tmp.length; i++){
            for(int j=0; j < tmp.length; j++){
                if(tmp[i][j] == 2){
                    if(!isBuildBeam(j,i,tmp))return false;
                    if(!isBuildPillar(j,i,tmp))return false;
                }else if(tmp[i][j] == 1){
                    if(!isBuildBeam(j,i,tmp))return false;
                }else if(tmp[i][j] == 0){
                    if(!isBuildPillar(j,i,tmp))return false;
                }
            }
        }
        return true;
    }

    private boolean isBuildPillar(int x, int y, int[][] m){
        if(y ==0) return true; //바닥이면 설치
        else if(m[y-1][x] == 0 || m[y-1][x] == 2) return true; //아래가 기둥이면 설치
        else return m[y][x] >= 1 || (x != 0 && m[y][x - 1] >= 1); //아래가 공중에있는 보라면 설치
    }
    private boolean isBuildBeam(int x, int y, int[][] m){
        if(y==0) return false; //바닥이면 설치 불가
        else if(m[y-1][x] == 0 || m[y-1][x] == 2 || (x+1 < m.length) && (m[y-1][x+1] == 0 || m[y-1][x+1] == 2)) return true; //기둥이있다면 설치
        else return x > 0 && (m[y][x - 1] >= 1) && (x < m.length && m[y][x + 1] >= 1);
    }

    @Test
    void test(){
        int[][] result = new int[][]{{1,0,0},{1,1,1},{2,1,0},{2,2,1},{3,2,1},{4,2,1},{5,0,0},{5,1,0}};
        int[][] build_frame = new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        Assertions.assertArrayEquals(result,solution(5,build_frame));
    }

    @Test
    void test1(){
        int[][] result = new int[][]{{0,0,0},{0,1,1},{1,1,1},{2,1,1},{3,1,1},{4,0,0}};
        int[][] build_frame = new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        Assertions.assertArrayEquals(result,solution(5,build_frame));
    }
}
