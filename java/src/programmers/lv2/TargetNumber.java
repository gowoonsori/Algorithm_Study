package programmers.lv2;

public class TargetNumber {
    static int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(target,0,0,numbers);
        return answer;
    }
    void dfs(int target,int sum,int index, int[] numbers){
        if(index == numbers.length){
            if(sum == target)answer++;
            return;
        }
        dfs(target,sum+numbers[index], index+1, numbers);
        dfs(target,sum-numbers[index], index+1, numbers);
    }
}
