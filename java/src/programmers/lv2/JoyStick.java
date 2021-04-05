package programmers.lv2;

import java.util.Arrays;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        char[] t = new char[name.length()]; Arrays.fill(t,'A');
        StringBuilder tmp = new StringBuilder(String.valueOf(t));
        int index = 0, size = name.length();

        while(!name.equals(tmp.toString())){
            tmp.replace(index,index+1,String.valueOf(name.charAt(index)));
            answer += tmp.charAt(index) > 'M' ?  'Z' - tmp.charAt(index) + 1 : tmp.charAt(index) - 'A';

            for(int i=0; i < size; i++){
                if( name.charAt( (i + index) % size ) != tmp.charAt((i + index) % size) ){
                    answer += i;
                    index = (i + index) % size;
                    break;
                }else if( name.charAt( (size + index - i) % size ) != tmp.charAt((size + index -i) % size) ){
                    answer += i;
                    index =  (size + index - i) % size;
                    break;
                }
            }
        }

        return answer;
    }
}
