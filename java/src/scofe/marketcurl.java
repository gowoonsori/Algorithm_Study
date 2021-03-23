package scofe;

import java.util.Scanner;

/*
*
* 입력
3
111
*
4
1101
*
5
11111
*
*출력
2
*
1
*
5
* */


public class marketcurl {
    static int N;
    static int[] route = new int[51];
    static long[] answer = new long[51];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();

        String s = scanner.nextLine();
        for(int i=0; i < s.length();i++){
            route[i] = s.charAt(i) - '0';
        }

        for(int i=0; i < N; i++){
            if(route[i] == 0) {
                answer[i] = 0;
                continue;
            }
            if((i == 0) || (i == 1)) answer[i] = 1;
            else answer[i] = answer[i-1] + answer[i-2];
        }
        System.out.println(answer[N-1]);
    }
}
