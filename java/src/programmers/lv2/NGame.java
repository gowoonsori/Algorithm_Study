package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NGame {
    char[] alp = {'A','B','C','D','E','F'};
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int index = 0;

        root:while(true){
            String numStr = changeNumber(num++, n);
            for(int i=0; i < numStr.length(); i++,index++ ){
                if((index % m) + 1 == p) answer += numStr.charAt(i);
                if(answer.length() == t) break root;
            }
        }

        return answer;
    }

    private String changeNumber(int num, int n){
        String tmp ="";
        while(num > 0){
            tmp = ( num % n > 9 ? String.valueOf(alp[num%n - 10]) : String.valueOf(num % n) ) + tmp ;
            num /= n;
        }
        return  tmp.isBlank()? "0" : tmp;
    }
    @Test
    void test(){
        Assertions.assertEquals("0111",solution(2,4,2,1));
    }
}
