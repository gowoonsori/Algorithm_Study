package hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quartiles {
    public List<Integer> quartiles(List<Integer> arr) {
        // Write your code here
        int len = arr.size();
        int[] array = arr.stream().mapToInt(Integer::intValue).toArray();
        int[] lowerHalf = new int[len];
        int[] upperHalf = new int[len];
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(array);

        //q2
        if (len % 2 == 0) {
            lowerHalf = Arrays.copyOfRange(array  , 0, len / 2 );
            upperHalf = Arrays.copyOfRange(array, len / 2, len );
        } else {
            lowerHalf = Arrays.copyOfRange(array, 0, len / 2 );
            upperHalf = Arrays.copyOfRange(array, len / 2 + 1, len );
        }
        answer.add(median(lowerHalf));
        answer.add(median(array));
        answer.add(median(upperHalf));

        return answer;
    }

    int median(int[] arr) {
        int arrLength = arr.length;
        if (arrLength % 2 == 1) {
            return arr[arrLength / 2];
        } else {
            return (arr[arrLength / 2 - 1] + arr[arrLength / 2]) / 2;
        }
    }

    @Test
    void test(){
        List<Integer> list = Arrays.asList(3,7,8,5,12,15,21,13,18);
        quartiles(list);
    }
}
