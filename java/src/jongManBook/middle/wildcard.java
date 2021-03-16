package jongManBook.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
* 종만북 (p 219) 와일드 카드
*
* 입력 예
3
he?p
3
help
heap
helpp
*p*
3
help
papa
hello
*bb*
1
babbbc
*/
public class wildcard {
    static int C,n;
    static String wildCard, file;
    static String[] files = new String[50];
    static int used[][] = new int[101][101];  //?번째 wildcard와 ?번째 filename 검사 완료했는지 check | -1 : 안함, 1: check성공, 0:check실패


    public static void main(String[] args) {
        List<String> answers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        C = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i < C; i++){
            for(int[] a : used) Arrays.fill(a,-1);
            wildCard = scanner.nextLine();
            n = scanner.nextInt(); scanner.nextLine();

            for(int j = 0; j < n; j++){
               file = scanner.nextLine();
                if(check(0,0) == 1) answers.add(file);
            }
        }
        answers.forEach(s -> System.out.println(s));
    }
    public static int check(int w, int s){
        int result = used[w][s];
        if(result != -1) return result;

        if(w < wildCard.length() && s < file.length() && (wildCard.charAt(w) == '?' || wildCard.charAt(w) == file.charAt(s))){
            return used[w][s] = check(w+1, s+1);
        }
        if(w == wildCard.length()) return used[w][s] = (s == file.length()) ? 1 : 0;
        if(wildCard.charAt(w) == '*'){
            if(check(w+1, s) == 1 || (s < file.length() && (check(w, s+1) == 1))){
                return used[w][s] = 1;
            }
        }
        return used[w][s] = 0;
    }
}
