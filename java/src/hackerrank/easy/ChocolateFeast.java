package hackerrank.easy;

import org.junit.jupiter.api.Test;

public class ChocolateFeast {
    public static int chocolateFeast(int n, int c, int m) {
        // Write your code here
        int answer = n / c;
        int remain = answer;

        while(remain >= m){
            answer++;
            remain-= m-1;
        }
        return answer;
    }
    @Test
    void test(){
        chocolateFeast(10,2,5);
    }
}
