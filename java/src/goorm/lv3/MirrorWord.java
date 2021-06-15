package goorm.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MirrorWord {
    static Map<Character,Character> map = new HashMap<>();

    public static void init(){
        map.put('b', 'd');
        map.put('d', 'b');
        map.put('i', 'i');
        map.put('l', 'l');
        map.put('m', 'm');
        map.put('n', 'n');
        map.put('o', 'o');
        map.put('p', 'q');
        map.put('q', 'p');
        map.put('s', 'z');
        map.put('z', 's');
        map.put('u', 'u');
        map.put('v', 'v');
        map.put('w', 'w');
        map.put('x', 'x');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        int N= Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i=0; i < N; i++){
            list.add(isMirror(br.readLine()));
        }
        list.forEach(System.out::println);
    }
    public static String isMirror(String word){
        int len = word.length();
        if( len == 1) {
            if(map.containsKey(word.charAt(0))){
                if(word.charAt(0)=='b' ||
                        word.charAt(0) == 'd' ||
                        word.charAt(0) == 'p' ||
                        word.charAt(0) == 'q' ||
                        word.charAt(0) == 's' ||
                        word.charAt(0) == 'z' ) return "Normal";
                else return "Mirror";
            }
            else return "Normal";
        }

        int left = len/2 -1,right;
        if( len % 2 == 0)right = len/2;
        else right = len/2+1;

        while(left >= 0){
            if(map.getOrDefault(word.charAt(left--),'.') != word.charAt(right++)) return "Normal";
        }
        return "Mirror";
    }

}
