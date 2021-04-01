package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class MakeLargeNumber {
    public String solution(String number, int k) {
        char[] answer = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        int size = number.length();
        for(int i=0; i < size ;i++){
            char ch = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < ch && k >0){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        for(int i= 0;  i< answer.length; i++) answer[i] = stack.get(i);
        return new String(answer);
    }

    @Test
    void test(){
        Assertions.assertEquals("775841",solution("4177252841",4));
    }
    @Test
    void test1(){
        Assertions.assertEquals("999",solution("994493",3));
    }
}
