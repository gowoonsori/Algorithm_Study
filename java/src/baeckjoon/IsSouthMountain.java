package baeckjoon;

import java.util.Scanner;

public class IsSouthMountain {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean increase = true;
        int N = Integer.parseInt(sc.nextLine());
        String answer = "YES";

        int curr = sc.nextInt();
        int next;
        for(int i=0; i < N-1; i++){
            next = sc.nextInt();
            if(curr == next) answer = "NO";
            if(increase){
                if(next < curr) increase = false;
            }else{
                if(next > curr) answer = "NO";
            }
            curr = next;
        }
        System.out.println(answer);
    }
}
