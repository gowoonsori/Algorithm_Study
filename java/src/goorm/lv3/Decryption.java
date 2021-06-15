package goorm.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Decryption {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine() );
        Map<Integer, Stack<String>> map = new HashMap<>();

        String input;
        for(int i=0; i < n; i++){
            input = br.readLine();
            map.putIfAbsent(input.length(), new Stack<>());
            map.get(input.length()).add(input);
        }

        Map<Integer, Stack<String>> tmp = new HashMap<>();
        Stack<String> s;
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isDecrypt;
        while((input = br.readLine()) != null){
            tmp.clear(); tmp.putAll(map); sb.setLength(0);
            String[] words = input.split(" ");
            int len = words.length;
            isDecrypt = true;

            for(int i=0; i < len; i++){
                s = map.get(words[i].length());
                if(s.isEmpty()){
                    isDecrypt = false;
                    break;
                }
                String str = s.pop();
                if(str.equals(words[i])){
                    if(s.isEmpty()){
                        isDecrypt = false;
                        break;
                    }
                    sb.append(s.pop());
                    s.push(str);
                }else {
                    sb.append(str);
                }

                if(i != len-1) sb.append(" ");
            }
            if(isDecrypt) answer.add(sb.toString());
            else answer.add(input.replaceAll("[a-z]","*"));
        }

        answer.forEach(System.out::println);
    }
}
