package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class NewsClusturing {
    public int solution(String str1, String str2) {
        Map<String,Integer> map1 = getSetFromString(str1);
        Map<String,Integer> map2 = getSetFromString(str2);

        int interaction = countInteraction(map1,map2);
        int union = countSetSize(map1) + countSetSize(map2) - interaction;
        return union == 0?  65536 : (int)Math.floor( interaction/(double)union * 65536 );
    }

    private Map<String,Integer> getSetFromString(String str){
        Map<String,Integer> map = new HashMap<>();
        str = str.toUpperCase();

        String sb;
        for(int i=0; i < str.length()-1;i++){
            sb = str.substring(i,i+2);
            if(sb.matches("[A-Z]{2}")){
                map.put(sb, map.getOrDefault(sb,0)+1);
            }
        }
        return map;
    }
    private int countInteraction(Map<String,Integer> m1, Map<String,Integer> m2){
        int cnt=0;
        for(Map.Entry<String,Integer> entry : m1.entrySet())
            cnt += (Math.min(entry.getValue(),m2.getOrDefault(entry.getKey(),0)));

        return cnt;
    }
    private int countSetSize(Map<String,Integer> m){
        int cnt =0;
        for(Integer value : m.values()) cnt += value;
        return cnt;
    }

    @Test
    void test(){
        Assertions.assertEquals(16384, solution("FRANCE","french"));
    }

    @Test
    void test1(){
        Assertions.assertEquals(	65536, solution("handshake", "shake hands"));
    }

    @Test
    void test2(){
        Assertions.assertEquals(		43690, solution(	"aa1+aa2", "AAAA12"));
    }
    @Test
    void test3(){
        Assertions.assertEquals(		65536, solution(	"E=M*C^2", "e=m*c^2"));
    }
}


