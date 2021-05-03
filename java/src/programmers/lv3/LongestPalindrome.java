package programmers.lv3;

public class LongestPalindrome {
    public int solution(String s) {
        int answer = 1;
        int len = s.length();
        boolean[][] isSame = new boolean[len][len];
        for(int i=0; i < len; i++){
            isSame[i][i] = true;
            if(i != len-1 && s.charAt(i) == s.charAt(i+1)) isSame[i][i+1] = true;
        }

        for(int i = 3; i <= len; i++){
            for(int j = 0; j <= len - i; j++){
                if(isSame[j+1][j+i-2] && s.charAt(j) == s.charAt(j+i-1)){
                    isSame[j][j+i-1] = true;
                    answer = i;
                }
            }
        }
        return answer;
    }
}
