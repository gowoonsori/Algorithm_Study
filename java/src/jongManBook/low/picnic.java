package jongManBook.low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class picnic {
    static boolean isFrirend[][] = new boolean[10][10];
    static int N, M;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        boolean[] visited = new boolean[10];
        Arrays.fill(visited, false);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            for (int j = 0; j < M; j++) {
                int friend1 = scanner.nextInt();
                int friend2 = scanner.nextInt();
                isFrirend[friend1][friend2] = true;
                isFrirend[friend2][friend1] = true;
            }
            arr.add(solution(visited));

            for (boolean a[] : isFrirend)
                Arrays.fill(a, false);
            Arrays.fill(visited, false);
        }
        arr.forEach(result -> System.out.println(result));
    }

    public static int solution(boolean[] visited) {
        int first = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                first = i;
                break;
            }
        }
        if (first == -1) return 1;
        int result = 0;

        for (int pair = first + 1; pair < N; pair++) {
            if (!visited[pair] && isFrirend[first][pair]) {
                visited[first] = visited[pair] = true;
                result += solution(visited);
                visited[first] = visited[pair] = false;
            }
        }
        return result;
    }
}
