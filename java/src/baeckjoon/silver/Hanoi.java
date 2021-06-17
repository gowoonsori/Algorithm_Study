package baeckjoon.silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hanoi {
    public static final Scanner sc = new Scanner(System.in);
    public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final List<String> answer = new ArrayList<>();
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();

        hanoi(1,2,3,n);

        bw.write(cnt + "\n");
        for(String s : answer) bw.write(s);

        bw.close();
        sc.close();
    }
    public static void hanoi(int start,int mid, int dest, int n){
        if(n == 0) return;

        hanoi(start, dest, mid, n-1);
        cnt++;
        answer.add(start + " " + dest+"\n");
        hanoi(mid, start, dest, n-1);
    }
}
