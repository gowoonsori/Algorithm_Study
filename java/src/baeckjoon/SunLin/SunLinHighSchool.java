package baeckjoon.SunLin;

import java.util.Scanner;

public class SunLinHighSchool {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        System.out.println(str.substring(N-5));
    }
}
