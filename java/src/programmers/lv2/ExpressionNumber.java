package programmers.lv2;


/*
* 어떤 정수의 연속된 숫자로 표현하는 경우의 수는 그 수의 홀수약수의 개수와 같다.
* */

public class ExpressionNumber {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i += 2) {
            if (n % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}
