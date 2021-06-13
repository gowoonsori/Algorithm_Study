package hackerrank.middle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ShelockAndValidString {

    public static String isValid(String s) {
        // Write your code here
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        Map<Integer,Integer> cnt = new HashMap<>();
        for(Integer val : map.values()){
            cnt.put(val, cnt.getOrDefault(val,0)+1);
        }
        if(cnt.size() > 2) return "NO";
        else if(cnt.size() == 1) return "YES";


        for(Map.Entry<Integer,Integer> entry : cnt.entrySet()){
            if(entry.getValue() == 1){
                if(entry.getKey()== 1 || cnt.containsKey(entry.getKey()-1)) return "YES";
                else return "NO";
            }
        }
        return "NO";
    }
    @Test
    void test(){
        Assertions.assertEquals("YES", isValid("aabbc"));
    }
}
