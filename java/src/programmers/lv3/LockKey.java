package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockKey {
    public boolean solution(int[][] key, int[][] lock) {
        /*key가 맞는지 비교를 위해 4면으로 여유둔 lock 새로 생성*/
        int keySize = key.length;
        int lockSize = lock.length;
        int[][] tmpLock = new int[lockSize + (keySize-1)*2][lockSize + (keySize-1)*2];
        for(int i=0; i < lockSize; i++){
            for(int j=0; j < lock[0].length; j++){
                tmpLock[(keySize-1)+i][(keySize-1)+j] = lock[i][j];
            }
        }

        /*키가 맞는지 돌려가면서 체크*/
        int len = tmpLock.length - keySize;
        for(int y=0; y <= len; y++){
            for(int x=0; x <= len; x++){
                for(int i=0; i < 4; i++){
                    rotate(key);
                    if(check(x,y,key, tmpLock,lockSize)) return true;
                }
            }
        }
        return false;
    }

    private boolean check(int x,int y,int[][] key, int[][] tmpLock,int lockSize){
        /*lock 무결성을 위해 복사*/
        int[][] tmp = new int[tmpLock.length][tmpLock.length];
        for(int i=0; i < tmpLock.length; i++)
            System.arraycopy(tmpLock[i],0,tmp[i],0,tmpLock.length);

        /*key 맞추기*/
        for(int i=0; i < key.length; i++){
            for(int j=0; j < key.length; j++){
                tmp[i+y][j+x] += key[i][j];
            }
        }

        /*모두 맞았는지 확인*/
        int start = (tmpLock.length - lockSize) /2;
        for(int i=start; i < lockSize+start; i++){
            for(int j=start; j < lockSize+start; j++){
                if(tmp[i][j] != 1) return false;
            }
        }
        return true;
    }

    private void rotate(int[][] key){
        int size = key.length;
        int[][] tmp = new int[size][size];

        /*회전*/
        for(int i=0; i < size; i++){
            for(int j=0; j < size; j++){
                tmp[i][j] = key[size-j-1][i];
            }
        }
        /*깊은 복사*/
        for(int i=0; i < size; i++)
            System.arraycopy(tmp[i],0,key[i],0,size);
    }


    @Test
    void test(){
        Assertions.assertEquals(true, solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}
        , new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }

    @Test
    void test1(){
        Assertions.assertEquals(false, solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}
                , new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }
    @Test
    public void testCase_1() {
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        Assertions.assertEquals(true,solution(key, lock));
    }

    @Test
    public void testCase_2() {
        int[][] key = new int[][]{{0, 0}, {1, 0}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        Assertions.assertEquals(false,solution(key, lock));
    }

    @Test
    public void testCase_3() {
        int[][] key = new int[][]{{0, 0}, {1, 0}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 1, 1}};

        Assertions.assertEquals(true,solution(key, lock));
    }

    @Test
    public void testCase_4() {
        int[][] key = new int[][]{{1, 0}, {1, 0}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 1}, {0, 0, 1}};

        Assertions.assertEquals(true,solution(key, lock));
    }
    @Test
    void rotateTest(){
        int[][] key = new int[][]{{0,0, 0, 0}, {1,0, 0, 0}, {0, 1,0, 1},{0, 1,0, 1}};
        rotate(key);
        rotate(key);
        rotate(key);
        rotate(key);
        System.out.println(key);
    }
}
