package programmers.lv3;

public class NExpression {
    int answer = 10;
    int n, target;
    public int solution(int N, int number) {
        n = N; target = number;
        dfs(0, 0);
        return answer > 8 ? -1 : answer;
    }
    private void dfs(int currNum, int cnt){
        if(cnt > 8)return;
        if(target == currNum){
            answer = Math.min(answer, cnt);
            return;
        }

        int num = 0;
        for(int i=0; i < 9; i++){
            num = num*10 + n;
            dfs(currNum + num, cnt+i+1);
            dfs(currNum - num, cnt+i+1);
            if(currNum!=0){
                dfs(currNum * num, cnt+i+1);
                dfs(currNum / num, cnt+i+1);
            }
        }

    }
}
