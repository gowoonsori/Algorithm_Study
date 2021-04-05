package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public int solution(int n) {
        int answer = 0;
        List<Integer> dp = new ArrayList<>();
        dp.add(0); dp.add(1);
        if(n < 2) return dp.get(n);

        for(int i = 2; i <= n; i++)
            dp.add( (dp.get(i-2) + dp.get(i-1) ) % 1234567);

        answer = dp.get(dp.size()-1);
        return answer;
    }
}
