package hackerrank.middle;

import java.math.BigInteger;

public class ExtraLongFactorials {

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger result = BigInteger.valueOf(1);

        for(int i=2; i<= n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}
