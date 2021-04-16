package programmers.lv2;

public class ExpectTable {
    public int solution(int n, int a, int b) {
        int answer = 1;
        while(n > 0){
            if(a%2 == 1) a++;
            if(b%2 == 1) b++;
            if(a == b)break;
            a/=2;
            b/=2;
            answer++;
            n/=2;
        }
        return answer;
    }
}
