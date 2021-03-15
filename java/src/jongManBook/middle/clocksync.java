package jongManBook.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
168p. 시계맞추기

*입력 예제
2
12 6 6 6 6 6 12 12 12 12 12 12 12 12 12 12
12 9 3 12 6 6 9 3 12 9 12 9 12 12 6 6
*
* */

public class clocksync {
    final static int INF = 99999999;
    static int C;
    static int clocks[] = new int[16];
    static String connect_switch[] = {
            "xxx.............",
            "...x...x.x.x....",
            "....x.....x...xx",
            "x...xxxx........",
            "......xxx.x.x...",
            "x.x...........xx",
            "...x..........xx",
            "....xx.x......xx",
            ".xxxxx..........",
            "...xxx...x...x.."};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        C = scanner.nextInt();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i < C; i++){
            for(int j = 0; j < 16; j++)
                    clocks[j] = scanner.nextInt();

            int result = solution(0);
            if(result == INF) result = -1;
            answer.add(result);
        }
        answer.forEach(r -> System.out.println(r));
    }

    public static int solution(int clock_switch){
        if(clock_switch == 10) return check() ? 0 : INF;

        int result = INF;
        for(int i=0; i < 4; i++){
            result = Math.min(result, solution(clock_switch + 1) + i);
            push(clock_switch);
        }
        return result;
    }

    public static boolean check(){
        for(int clock : clocks)
            if(clock != 12) return false;
        return true;
    }

    public static void push(int clock_switch){
        for(int i=0; i < 16; i++){
            if(connect_switch[clock_switch].charAt(i) == 'x') {
                clocks[i] += 3;
                if (clocks[i] == 15) clocks[i] = 3;

            }
        }
    }
}
