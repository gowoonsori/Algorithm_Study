package hackerrank.easy;

import java.util.Arrays;
import java.util.List;

public class InterQuaritileRange {
    public void interQuartile(List<Integer> values, List<Integer> freqs) {
        // Print your answer to 1 decimal place within this function
        int N = freqs.stream().mapToInt(Integer::intValue).sum();
        int[] arr = new int[N];

        int index = 0;
        for(int i=0; i <values.size(); i++){
            for(int j = 0; j < freqs.get(i); j++){
                arr[index++] = values.get(i);
            }
        }
        Arrays.sort(arr);

        int[] lowerHalf = Arrays.copyOfRange(arr,0, N/2);
        int[] upperHalf;
        if(N % 2 == 0)upperHalf = Arrays.copyOfRange(arr,N/2,N);
        else upperHalf = Arrays.copyOfRange(arr,N/2+1,N);

        double q1 = median(lowerHalf);
        double q3 = median(upperHalf);

        System.out.printf("%.1f",q3 - q1);
    }
    private double median(int[] arr){
        int len = arr.length;
        if(len % 2 == 0){
            return (arr[len/2 -1] + arr[len/2]) / 2;
        }else{
            return arr[len/2];
        }
    }
}
