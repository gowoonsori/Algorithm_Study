package programmers.makers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GiftCard {
    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        Map<Integer, Integer> want_item_cnt = new HashMap<>();
        Map<Integer, Integer> gift_item_cnt = new HashMap<>();

        for(int i =0 ;i < wants.length; i++){
            if(wants[i] != gift_cards[i]){
                want_item_cnt.put(wants[i],want_item_cnt.getOrDefault(wants[i],0) + 1);
                gift_item_cnt.put(gift_cards[i],gift_item_cnt.getOrDefault(gift_cards[i],0) + 1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : want_item_cnt.entrySet()){
            int gift_num = entry.getKey();
            int cnt = entry.getValue();
            if(gift_item_cnt.containsKey(gift_num) && cnt != gift_item_cnt.get(gift_num)){
                answer += Math.abs(cnt - gift_item_cnt.get(gift_num));
            }else if(!gift_item_cnt.containsKey(gift_num)){
                answer += cnt;
            }
        }
        return (answer+1) / 2;
    }
    @Test
    void test(){
        Assertions.assertEquals(1, solution(new int[]{4,5,3,2,1}, new int[]{2,4,4,5,1}));
    }
    @Test
    void test1(){
        Assertions.assertEquals(3, solution(new int[]{5,4,5,4,5}, new int[]{1,2,3,5,4}));
    }
    @Test
    void test2(){
        Assertions.assertEquals(0, solution(new int[]{5,5,5,5,5}, new int[]{5,5,5,5,5}));
    }
    @Test
    void test3(){
        Assertions.assertEquals(1, solution(new int[]{1,5,5,5,5}, new int[]{5,5,5,5,5}));
    }
}
