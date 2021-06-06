package hackerrank.easy;

import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifferenceInAnArray {
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here

        Collections.sort(arr);
        int diff = Integer.MAX_VALUE;

        int N = arr.size();
        for(int i =0; i < N-1; i++){
            diff = Math.min(diff, arr.get(i+1) - arr.get(i));
        }
        return diff;
    }
}
