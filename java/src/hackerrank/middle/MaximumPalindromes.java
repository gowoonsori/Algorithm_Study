package hackerrank.middle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class MaximumPalindromes {
    static String word;
    static int mod = 1000000007;
    static BigInteger[] fact;
    public static void initialize(String s) {
        // This function is called once before all queries.
        word = s;
        int n = s.length();
        fact = new BigInteger[n+1];
        fact[0] = BigInteger.ONE;
        for(int i=1; i <= n ; i++){
            fact[i] = fact[i-1].multiply(BigInteger.valueOf(i));
        }
    }

    /*
     * Complete the 'answerQuery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static int answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        String str = word.substring(l-1,r);
        int[] cnt = new int[26];

        /*cnt alpabet*/
        for(char ch : str.toCharArray()){
            cnt[ch-'a']++;
        }

        /*check pair charcter*/
        int even = 0, odd=0, div, rem;
        BigInteger distinct = BigInteger.ONE;
        for(int i=0; i < 26; i++){
            if(cnt[i] == 0) continue;
            div = cnt[i]/2;
            rem = cnt[i]%2;
            even += div;
            odd += rem;

            if(div > 1) distinct = distinct.multiply(fact[div]);
        }

        BigInteger answer = fact[even].divide(distinct);
        if(odd != 0) answer = answer.multiply(BigInteger.valueOf(odd));

        return answer.remainder(BigInteger.valueOf(mod)).intValueExact();
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
