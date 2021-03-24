package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class usefulSquare {
    public long solution(int w, int h) {
        long answer = (long)w*(long)h;
        int gcd = getGcd(Math.max(w,h), Math.min(w,h));

        w/= gcd; h /= gcd;
        answer -= gcd* ((long)w+(long)h-1);

        return answer;
    }
    int getGcd(int a, int b){
        while(b >0){
            int c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
    @Test
    void test(){
        Assertions.assertEquals(80,solution(8,12));
    }

}
