package jongManBook.low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boardcover {
    static boolean board[][] = new boolean[20][20];
    static int H,W;
    static int convertType[][][] = {
            {{0,0},{1,0},{0,1}},
            {{0,0},{1,0},{1,1}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{0,1},{-1,1}}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> answer = new ArrayList<>();
        int C = scanner.nextInt();

        for(int i=0; i < C; i++){
            for(boolean[] a: board)
                Arrays.fill(a,false);

            H = scanner.nextInt();
            W = scanner.nextInt();
            scanner.nextLine();
            for(int j = 0; j < H; j++){
                String str = scanner.nextLine();
                for(int k =0; k < W; k++){
                    if(str.charAt(k) == '#') board[j][k] = true;
                }
            }
            answer.add(solution());
        }
        answer.forEach(result -> System.out.println(result));
    }

    public static int solution(){
        int col = -1, row =-1;
        for(int i = 0; i < H; i++){
            for(int j=0; j < W; j++){
                if(!board[i][j]) {
                    col = j;
                    row = i;
                    break;
                }
            }
            if(row!= -1)break;
        }

        if(row == -1) return 1;
        int result = 0;
        for(int i=0; i < 4; i++){
            if(isPossible(col,row,i)){
                setBoard(col,row,i,true);
                result += solution();
                setBoard(col,row,i,false);
            }
        }
        return result;
    }

    static boolean isPossible(int col,int row,int type){
        for(int i=0; i < 3; i++){
            int nx = col + convertType[type][i][0];
            int ny = row + convertType[type][i][1];
            if(nx <0 || ny < 0 || nx >= W || ny >=H || board[ny][nx])return false;
        }
        return true;
    }
    //flag = true: 삽입 / false : 삭제
    static void setBoard(int col,int row,int type,boolean flag){
        for(int i=0; i < 3; i++){
            int nx = col + convertType[type][i][0];
            int ny = row + convertType[type][i][1];
            board[ny][nx] = flag;
        }
    }
}
