package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ParenthesesTransform {
    public String solution(String p) {
        if(check(p)) return p;
        else return rules(p);
    }
    boolean check(String str){
        Stack<Character> s = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '(') s.push(ch);
            else{
                if(s.isEmpty()) return false;
                else s.pop();
            }
        }
        return true;
    }
    String rules(String str){
        if(str.equals("")) return str;
        String u="", v="";
        int left = 0, right = 0;

        for(int i=0; i < str.length(); i++){
            if(str.charAt(i) == '(')left++;
            else right++;

            if(left == right){
                u = str.substring(0, i+1);
                v = str.substring(i+1);
                break;
            }
        }
        if(check(u)) return u + rules(v);
        else{
            String tmp = "(" + rules(v) + ")";  //u의 앞뒤 문자 제거 후
            u = u.substring(1,u.length()-1);    //고친 v의 결과에 () 더해주기

            //앞뒤 제거한 u 뒤집기
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i < u.length(); i++){
                if(u.charAt(i) == '(') stringBuilder.append(')');
                else stringBuilder.append('(');
            }
            tmp += stringBuilder.toString();
            return tmp;
        }
    }
    @Test
    void test1(){
        Assertions.assertEquals("(()())()",solution("(()())()"));
    }
    @Test
    void test2(){
        Assertions.assertEquals("()(())()",solution("()))((()"));
    }
    @Test
    void test3(){
        Assertions.assertEquals("()",solution(")("));
    }
    @Test
    void test4(){
        Assertions.assertEquals("",solution(""));
    }
}
