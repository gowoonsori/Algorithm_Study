package hackerrank.easy;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        System.out.println(Integer.valueOf(scan.next()) + i);
        System.out.println(Double.valueOf(scan.next()) + d);scan.nextLine();
        System.out.println(s + scan.nextLine());

        scan.close();
    }
}
