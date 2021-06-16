package baeckjoon;

import java.util.Scanner;

public class BreakEvenPoint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        if(B > C) System.out.println(-1);
        else{
            int profit = C - B;
            int answer = A / profit + 1;
            System.out.println(answer);
        }
    }
}
