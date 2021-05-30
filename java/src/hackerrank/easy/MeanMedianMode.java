package hackerrank.easy;

import java.util.Arrays;
import java.util.Scanner;

public class MeanMedianMode {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int N = scanner.nextInt();
        int mode = Integer.MAX_VALUE;
        double avg, median;

        int sum = 0;
        int[] arr = new int[N];
        int[] isUse = new int[100001];
        int distinctCnt = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            isUse[arr[i]]++;
            sum += arr[i];

            if (isUse[arr[i]] >= distinctCnt) {
                distinctCnt = isUse[arr[i]];
                mode = Math.min(mode, arr[i]);
            }
        }
        Arrays.sort(arr);

        avg = (double) sum / N;
        if (N % 2 == 0) median = (double) (arr[N / 2] + arr[N / 2 - 1]) / 2;
        else median = (double) arr[N / 2] / 2;

        System.out.printf("%.1f\n", avg);
        System.out.printf("%.1f\n", median);
        System.out.printf("%d\n", mode);
    }
}
