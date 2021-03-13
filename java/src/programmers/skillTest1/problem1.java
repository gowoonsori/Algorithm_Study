package programmers.skillTest1;

public class problem1 {
    public int solution(int n) {
        int answer = 0;
        boolean[] check = new boolean[1000000];

        for(int i = 0; i < n; i++){
            check[i] = false;
        }

        for(int i= 2; i <= n; i++){
            if(!check[i]){
                answer++;
                for(int j=i; j <= n; j+=i){
                    check[j] = true;
                }
            }
        }

        return answer;
    }
}
