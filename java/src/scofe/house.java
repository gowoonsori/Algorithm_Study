package scofe;

import java.util.Arrays;
import java.util.Scanner;

/*
* 입력
4
1110
1110
0110
0000
*
*
* 출력
total: 11
size[1]: 8
size[2]: 3
* */

public class house {
    static int N;
    static int answer[] = new int[51];
    static int room[][] = new int[51][51];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();

        Arrays.fill(answer,0);

        for(int i=0; i < N; i++){
            String s = scanner.nextLine();
            for(int j=0; j < N; j++){
                room[i][j] = s.charAt(j) - '0';
                if(room[i][j] == 1) answer[1]++;
            }
        }

        for(int size = 2; size <=N; size++) {
            for (int i = 0; i <= N-size; i++) {
                for (int j = 0; j <= N-size; j++) {
                    if (check(j, i, size)) answer[size]++;
                }
            }
        }

        int total=0;
        for(int i=0; i < N; i++)
            total += answer[i];

        System.out.println("total: " + total);
        for(int i=1; i <=N; i++) {
            if(answer[i] == 0) break;
            System.out.println("size[" + i  + "]: " + answer[i]);
        }
    }
    static boolean check(int x, int y,int size){
        for(int i=0; i < size; i++){
            for(int j=0; j < size; j++){
                if(room[i+y][j+x] == 0) return false;
            }
        }
        return true;
    }
}
