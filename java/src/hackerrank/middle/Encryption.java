package hackerrank.middle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Encryption {
    public String encryption(String s) {
        // Write your code here
        int N;
        int M = (int)Math.sqrt(s.length()-1)+1;
        int lastWordLength = ((s.length()-1) % M) + 1;
        StringBuilder sb = new StringBuilder();

        String[] words = split(s,M);
        N = words.length;

        for(int col=0; col < M; col++){
            for(int row = 0; row < N; row++){
                if(row== N-1 && col >= lastWordLength) break;
                sb.append(words[row].charAt(col));
            }
            sb.append(' ');
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private String[] split(String str, int n){
        int size = (str.length()-1)/n + 1;
        String[] result = new String[size];
        int index = 0, start=0, end= str.length();
        while(size > 0){
            String s;
            if(start + n > end) s = str.substring(start);
            else s = str.substring(start,start + n);

            result[index++] = s;
            start += n;
            size--;
        }
        return result;
    }
    @Test
    void test(){
        Assertions.assertEquals("isieae fdtonf fotrga anoyec cttctt tfhhhs", encryption("iffactsdontfittotheorychangethefacts"));
    }
}
