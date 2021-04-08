package programmers.lv2;

public class CorrectBracket {
    boolean solution(String s) {
        int cnt = 0;

        for(char ch : s.toCharArray()){
            if(ch == '(')cnt++;
            else{
                if(cnt == 0) return false;
                cnt--;
            }
        }

        return cnt > 0 ? false : true;
    }
}
