package baeckjoon;

import java.util.Scanner;

public class SunLinProblemD {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];
        for(int i=0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        if(N == 1) {
            System.out.println(1);
            return;
        }

        int answer = 1;
        int left=0,right=1, diff;
        while(right < N){
            diff = arr[right]- arr[left];

            if(diff > 2) {
                left++;
            }
            else {
                answer = Math.max(answer, right-left+1);
                right++;
            }
        }
        System.out.println(answer);
    }
}
