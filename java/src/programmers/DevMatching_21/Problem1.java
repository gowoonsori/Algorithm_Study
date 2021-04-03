package programmers.DevMatching_21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem1 {

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

    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{3,5}, solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));
    }
}
