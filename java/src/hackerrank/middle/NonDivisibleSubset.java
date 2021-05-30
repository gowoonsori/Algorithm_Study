package hackerrank.middle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NonDivisibleSubset {
    public int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here]
        int result = 0;
        int[] div = new int[100];
        for(Integer i : s) div[i%k]++;

        if(k % 2 ==0 && div[k%2] > 0) result++;
        if(div[0] > 0) result++;
        for(int i=1; i <= k/2; i++){
            if( i == k-i ) continue;
            result += Math.max(div[i], div[k-i]);
        }

        return result;
    }
    @Test
    void test(){
        int[] s = new int[]{1,7,2,4};

        Assertions.assertEquals(3,  nonDivisibleSubset(4,
                IntStream.of(s).boxed().collect(Collectors.toList())));
    }
}
