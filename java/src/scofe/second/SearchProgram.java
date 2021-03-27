package scofe.second;

import java.util.Scanner;

public class SearchProgram {
    static int N,Q;
    static String[] wordList;
    public static void main(String[] args) {
        int[] answer;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); scanner.nextLine();
        wordList = new String[N];
        for(int i=0 ; i < N; i++){
            wordList[i] = scanner.nextLine();
        }

        Q = scanner.nextInt(); scanner.nextLine();
        answer = new int[Q];
        int cnt; StringBuilder stringBuilder;
        for(int i=0; i < Q; i++){
            cnt = 0;
            String word = scanner.nextLine();
            for(int j=0; j < N; j++){
                if(wordList[j].length() < word.length())continue;
                stringBuilder = new StringBuilder(wordList[j]);
                if(stringBuilder.indexOf(word) != -1) cnt++;
            }
            answer[i] = cnt;
        }
        for(int a : answer) System.out.println(a);
    }
}
