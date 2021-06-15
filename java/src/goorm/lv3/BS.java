package goorm.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        int search = Integer.parseInt(br.readLine());

        int start =0, end = arr.length-1,mid;
        while(start < end){
            mid = (start + end )/2;

            if(arr[mid] < search) start = mid+1;
            else end = mid;
        }

        if(arr[start] == search) System.out.println(start+1);
        else System.out.println("X");
    }
}
