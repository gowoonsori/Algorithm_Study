package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return 5* cities.length;

        Stack<String> cache = new Stack<>();
        for(String city : cities){
            city = city.toLowerCase();
            if(cache.contains(city)){
                cache.remove(city);
                cache.push(city);
                answer++;
            }else if( cache.size() < cacheSize ){
                answer+=5;
                cache.push(city);
            }else{
                cache.remove(0);
                cache.push(city);
                answer+=5;
            }
        }
        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(50, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
    @Test
    void test1(){
        Assertions.assertEquals(16, solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
    }
    @Test
    void test2(){
        Assertions.assertEquals(16, solution(0, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
    }
}
