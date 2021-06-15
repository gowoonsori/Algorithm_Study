package goorm.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombineArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr1 = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
        int[] newArr = new int[N+M];

        System.arraycopy(arr1,0,newArr,0,N);
        System.arraycopy(arr2,0,newArr,N,M);
        Arrays.sort(newArr);

        Arrays.stream(newArr).forEach(n -> System.out.print(n + " "));
    }
}
