package programmers.lv3;

public class Lotoo {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[]{0,0};

        int min = 0, max = 0;
        for(int i=0; i< lottos.length; i++) {
            if (lottos[i] == 0) {
                min++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (win_nums[j] == lottos[i]) {
                    min++;
                    max++;
                    break;
                }
            }
        }
        answer[0] = check(min);
        answer[1] = check(max);
        return answer;
    }
    public int check(int num){
        if(num >= 6) return 1;
        else if(num == 5) return 2;
        else if(num == 4)return 3;
        else if(num == 3)return 4;
        else if(num == 2)return 5;
        else return 6;
    }
}
