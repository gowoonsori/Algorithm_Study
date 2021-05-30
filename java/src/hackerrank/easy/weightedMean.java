package hackerrank.easy;

import java.util.List;

public class weightedMean {
    public static void weightedMean(List<Integer> X, List<Integer> W) {
        // Write your code here
        int xSum = 0;
        int wSum = 0;
        int n = X.size();
        for(int i = 0; i < n; i++){
            xSum += X.get(i) * W.get(i);
            wSum += W.get(i);
        }
        System.out.printf("%.1f", (double)xSum / wSum);
    }
}
