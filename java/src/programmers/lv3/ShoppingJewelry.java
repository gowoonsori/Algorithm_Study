package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ShoppingJewelry {
    public int[] solution(String[] gems) {
        int gemsLength = gems.length;
        int[] answer = new int[]{1,gemsLength};
        Map<String,Integer> gemMap = new HashMap<>();

        //보석 종류 찾기
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));

        if(gemSet.size() == 1) return new int[]{1,1};

        //가장 짧은 구간 찾기
        int min = Integer.MAX_VALUE;
        int idx=0;
        Queue<String> q= new LinkedList<>();
        for(int i=0; i < gemsLength; i++){
            gemMap.put(gems[i], gemMap.getOrDefault(gems[i],0) + 1);
            q.add(gems[i]);

            while(true){
                String tmp = q.peek();
                if(gemMap.get(tmp) > 1){
                    gemMap.put(tmp, gemMap.get(tmp) - 1);
                    q.poll();
                    idx++;
                }else break;
            }
            if(gemMap.size() == gemSet.size() && min > q.size()){
                min = q.size();
                answer[0] = idx + 1;
                answer[1] = idx + min;
            }
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{3,7}, solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
    }
}
