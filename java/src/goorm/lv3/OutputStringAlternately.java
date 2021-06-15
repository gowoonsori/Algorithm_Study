package goorm.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OutputStringAlternately {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int start =0, last = input.length()-1;

        StringBuilder sb = new StringBuilder();
        while(start < last){
            sb.append(input.charAt(start++)).append(input.charAt(last--));
        }
        if(start == last) sb.append(input.charAt(start));

        System.out.println(sb);
    }
}
