package baeckjoon.SunLin;

import java.util.Scanner;

public class Omit {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        if(N <= 25) System.out.println(str);
        else{
            String remain = str.substring(12,N-11);
            int index = remain.indexOf(".");
            if(index == -1 || index == remain.length()-1){
                System.out.println(str.substring(0,11).concat("...").concat(str.substring(N-11)));
            }else {
                System.out.println(str.substring(0,9).concat("......").concat(str.substring(N-10)));

            }
        }
    }
}
