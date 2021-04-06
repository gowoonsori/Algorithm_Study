package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class Camoflague {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> fashion = new HashMap<>();

        for(int i=0; i < clothes.length; i++){
            fashion.put(clothes[i][1],fashion.getOrDefault(clothes[i][1],0)+1);
        }
        for(Map.Entry<String,Integer> entry : fashion.entrySet()){
            answer *= entry.getValue()+1;
        }

        return answer-1;
    }
}
