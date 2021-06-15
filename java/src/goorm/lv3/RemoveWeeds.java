package goorm.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemoveWeeds {
    static int N,Q;
    static int[] weeds;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        Q = Integer.parseInt(input[1]);
        weeds = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i < Q; i++){
            input = br.readLine().split(" ");
            if(input[0].equals("1")){
                System.out.println(calculate(Integer.parseInt(input[1]),Integer.parseInt(input[2])));
            }else if(input[0].equals("2")){
                weeds[Integer.parseInt(input[1])-1] += Integer.parseInt(input[2]);
            }else{
                weeds[Integer.parseInt(input[1])-1] -= Integer.parseInt(input[2]);
            }
        }
    }

    public static int calculate(int start, int end){
        int sum = 0;
        for(int i=start-1; i < end; i++){
            sum += weeds[i];
        }
        return sum;
    }
}
