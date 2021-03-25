package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class stock_price {
    public List<Integer> solution(int[] prices) {
        List<Integer> list = new ArrayList<>();
        int size = prices.length;

        for(int i=0; i < size;i++){
            int term = 0;
            for(int j=i+1; j < size; j++){
                term++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            list.add(term);
        }
        return list;
    }
}
