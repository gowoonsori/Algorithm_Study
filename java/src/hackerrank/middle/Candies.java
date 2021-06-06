package hackerrank.middle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Candies {
    public long candies(int n, List<Integer> arr) {
        // Write your code here
        int[] down = new int[n]; Arrays.fill(down,1);
        int[] up = new int[n]; Arrays.fill(up,1);
        if(n < 2) return 1;

        for(int i=1; i < n; i++){
            if(arr.get(i-1) < arr.get(i)) up[i] = up[i-1]+1;

            if(arr.get(n-i-1) > arr.get(n-i)) down[n-i-1] = down[n-i] + 1;
        }

        return IntStream.range(0,n).mapToLong(index -> Math.max(down[index],up[index])).sum();
    }
    @Test
    void test(){
        Assertions.assertEquals(19, candies(10, Arrays.asList(2,4,2,6,1,7,8,9,2,1)));
    }
}
