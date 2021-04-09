package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class MaxValueMinValue {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        Arrays.sort(numbers, Comparator.comparingInt(Integer::parseInt));

        answer = numbers[0] + " " + numbers[numbers.length-1];
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals("-4 -1", solution("-1 -2 -3 -4"));
    }
}
