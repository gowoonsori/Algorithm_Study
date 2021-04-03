package programmers.makers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class Item {
    List<Integer> parts;

    Item() { parts = new LinkedList<>(); }

    public List<Integer> getPart() { return parts; }

    public void addPart(int part) {
        parts.add(part);
    }

    public void removePart(int idx) {
        if (!parts.isEmpty()) parts.remove(idx);
    }

    public int getPartsCnt(){
        return parts.size();
    }
    public int getPartIndex(int part){
        for(int i = 0; i <parts.size(); i++){
            if(parts.get(i) == part) return i;
        }
        return -1;
    }
}

public class Robot {
    static List<Item> list = new ArrayList<>();
    public int solution(int[][] needs, int r) {
        int answer = 0;
        int part_cnt = needs[0].length;
        int item_cnt = needs.length;

        /*완제품 별 필요한 부품을 담는 완제품리스트 생성*/
        for (int i = 0; i < item_cnt; i++) {
            list.add(new Item());
            for (int j = 0; j < part_cnt; j++) {
                if (needs[i][j] == 1) {
                    list.get(i).addPart(j);
                }
            }
        }
        /*만들 수 없는 완제품은 제거*/
        int size = r;
        list = list.stream().filter(item -> item.getPartsCnt() <= size).collect(Collectors.toList());

        /*가장 많은 부품을 필요한 부품을 선택*/
        int max_item[] = new int[item_cnt];
        while (r > 0) {
            Arrays.fill(max_item, 0);
            for (Item item : list) {
                for(int part : item.getPart()){
                   max_item[part]++;
                }
            }

            int max = -1, max_idx = 0;
            for(int i = 0; i <max_item.length; i++){
                if(max < max_item[i]){
                    max = max_item[i];
                    max_idx = i;
                }
            }
            usePart(max_idx);
            r--;
        }

        answer = checkItem();
        return answer;
    }

    public void usePart( int part){
        for(Item item : list){
            int idx = item.getPartIndex(part);
            if(idx != -1){
                item.removePart(idx);
            }
        }
    }

    public int checkItem(){
        int result = 0;
        for(Item item : list){
            if(item.getPartsCnt() == 0){
                result++;
            }
        }
        return result;
    }

    @Test
    void test(){
        Assertions.assertEquals(4, solution(new int[][]{{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}}, 2));
    }
}
