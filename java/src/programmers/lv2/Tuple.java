package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();

        s = s.substring(2,s.length()-2).replaceAll("\\{","");
        String[] sets = s.split("},");
        Arrays.sort(sets, Comparator.comparingInt(String::length));

        Set<Integer> set = new HashSet<>();
        for(String str : sets){
            for(String st : str.split(",")){
                int num = Integer.valueOf(st);
                if(set.add(num))answer.add(num);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{2,1,3,4}, solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
        //ssertions.assertArrayEquals(new int[]{123}, solution("{{123}}"));
    }
}
