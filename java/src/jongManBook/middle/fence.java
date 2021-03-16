package jongManBook.middle;

/*
* 종만북 (195p)
*
* 입력 예시
3
7
7 1 5 9 6 7 3
7
1 4 4 4 4 1 1
4
1 8 2 2
* */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fence {
    static int C,N;
    static int fence_heights[] = new int[20000];

    public static void main(String[] args) {
        List<Integer> answers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        C = scanner.nextInt();

        for(int i=0; i < C; i++){
            N = scanner.nextInt();
            for(int j =0; j < N; j++){
                fence_heights[j] = scanner.nextInt();
            }
            answers.add(solution(0, N-1));
        }
        answers.forEach(s -> System.out.println(s));
    }
    public static int solution(int left, int right){
        if(left == right) return fence_heights[left];

        int mid = (left + right) / 2;
        int result = Math.max(solution(left,mid), solution(mid+1,right));

        int low = mid, high = mid+1;
        int height = Math.min(fence_heights[low], fence_heights[high]);
        result = Math.max(result,height*2);

        while(left < low || high > right){
            if(high < right && (low == left || fence_heights[low-1] < fence_heights[high+1])){
                high++;
                height = Math.min(height, fence_heights[high]);
            }else{
                low--;
                height = Math.min(height,fence_heights[low]);
            }
            result = Math.max(result, height * (high - low +1));
        }
        return result;
    }

}
