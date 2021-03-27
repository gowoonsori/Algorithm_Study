package scofe.second;

import java.util.Scanner;

public class audition {
    static int N;
    static int[] playlist = new int[100001];

    public static void main(String[] args) {
        int[] answer = {0,1};
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int time = 0;
        String s = scanner.next();scanner.nextLine();
        String[] arr = s.split(":");
        time = Integer.valueOf(arr[0])*3600 + Integer.valueOf(arr[1]) * 60 + Integer.valueOf(arr[2]);


        for (int i = 0; i < N; i++) {
            s = scanner.nextLine();
            arr = s.split(":");
            playlist[i] = Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
        }
        for(int i=0; i<N; i++){
            int result = solution(time,i);
            if(answer[0] < result){
                answer[0] = result;
                answer[1] = i+1;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
    public static int solution(int time,int start){
        int cnt = 0;
        for(int i = start; i < N; i++){
            cnt++;
            time -= playlist[i];
            if(time <= 0) break;
        }
        return cnt;
    }
}
