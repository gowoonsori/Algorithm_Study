package hackerrank.middle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MaximumPalindromes {
    String word = "";
    static int mod = 1000000007;

    public void initialize(String s) {
        word = s;
    }
    public int answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        String str = word.substring(l-1,r);
        Map<Character,Integer> map = new HashMap<>();

        /*cnt alpabet*/
        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        /*check pair charcter*/
        int even = 0, odd=0, div, rem;
        BigInteger distinct = BigInteger.ONE;
        for(Integer value : map.values()){
            div = value/2;
            rem = value%2;
            even += div;
            odd += rem;

            if(div > 1) distinct = distinct.multiply(factorial(div));
        }

        BigInteger answer = factorial(even).divide(distinct);
        if(odd != 0) answer = answer.multiply(BigInteger.valueOf(odd));

        return answer.remainder(BigInteger.valueOf(mod)).intValue();
    }

    BigInteger factorial(int n){
        BigInteger result = BigInteger.ONE;
        for(int i=1; i <= n ; i++){
            result = result.multiply(BigInteger.valueOf(i)) ;
        }
        return result;
    }

    @Test
    void test(){
        initialize("abab");

        int[][] input = new int[][]{{1,4}};
        int[] output = new int[]{2};

        for(int i=0; i < 1; i++){
            Assertions.assertEquals(output[i],answerQuery(input[i][0],input[i][1]));
        }
    }
}
