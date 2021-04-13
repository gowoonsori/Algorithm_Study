package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class RemovePair {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        int size = s.length();
        for(int i=0; i < size; i++){
            if(stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.peek() == s.charAt(i))stack.pop();
            else stack.push(s.charAt(i));
       }
        return stack.empty() ? 1 : 0;
    }
    @Test
    void test(){
        Assertions.assertEquals(1,solution("baabaa"));
    }
}
