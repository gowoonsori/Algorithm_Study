package programmers.lv2;

import java.util.Stack;

public class RotateBracket {


    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        int x = 0;
        StringBuilder sb = new StringBuilder(s);
        while(x++ < len){
            if( check(sb.toString())) answer++;
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return answer;
    }
    private boolean check(String str){
        Stack<Character> stack = new Stack<>();
        int len = str.length();

        for(int i=0; i < len; i++){
            if(stack.isEmpty() || str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i)== '[') {
                stack.push(str.charAt(i));
                continue;
            }
            if( !isPair(stack.peek(), str.charAt(i))) return false;
            stack.pop();
        }
        return stack.isEmpty();
    }
    private boolean isPair(char left, char right){
        switch (left){
            case '{':
                return right == '}';
            case '[':
                return right == ']';
            case '(':
                return right == ')';
            default:
                return false;
        }
    }
}
