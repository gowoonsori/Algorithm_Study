package jongManBook.low;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
* 쿼드 트리 뒤집게 (p. 194)
*
* 입력 예
*
3
w
xbwwb
xbwxwbbwb
*
* */
public class quadtree {
    static int C,pointer;
    static String quadtree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> answer = new ArrayList<>();
        C = scanner.nextInt();
        scanner.nextLine();

        for(int i =0; i < C; i++){
            quadtree = scanner.nextLine();
            pointer = 0;
            answer.add(solution());
        }
        answer.forEach(r -> System.out.println(r));
    }
    static String solution(){
        if(quadtree.charAt(pointer) != 'x'){
            pointer++;
            return quadtree.charAt(pointer-1) + "";
        }else {
            pointer++;
            String upperLeft = solution();
            String upperRight = solution();
            String lowerLeft = solution();
            String lowerRight = solution();

            return 'x'+ lowerLeft + lowerRight + upperLeft + upperRight;
        }
    }
}
