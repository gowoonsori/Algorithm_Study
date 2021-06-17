package baeckjoon.SunLin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SunLinProblemE {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();

        long num;
        List<Long> answer = new ArrayList<>();
        for(int i=0; i < T; i++){
            num = sc.nextLong();
            String s = Long.toBinaryString(num);
            answer.add(calculate(s));
        }
        answer.forEach(System.out::println);
    }
    public static long calculate(String binary){
        StringBuilder sb = new StringBuilder(binary);
        sb.reverse();

        int len = sb.length();
        long result = 0;
        for(int i=0; i < len; i++){
            if( sb.charAt(i) == '1' ){
                result += Math.pow(3,i);
            }
        }
        return result;
    }
}
