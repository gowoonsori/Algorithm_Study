package goorm.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FirstSecond {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(br.readLine());

        int index = input.indexOf("12");
        if(index == -1 ){
            System.out.println("No");
            return;
        }
        input.delete(index,index+2);
        if(input.indexOf("21") != -1 ) System.out.println("Yes");
        else System.out.println("No");


    }
}
