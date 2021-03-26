package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Renewal_menu {
    static Map<String, Integer> count_menu = new HashMap<>();
    static int[] max_count_menu = new int[21];
    static List<String>[] select_courses = new ArrayList[21];

    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i < select_courses.length; i++) select_courses[i] = new ArrayList<>();
        for (String str : orders) {
            char[] c = str.toCharArray(); Arrays.sort(c);
            combine(new String(c), -1, "");
        }

        for (int i : course) {
            if(max_count_menu[i] > 1){
                for(String s : select_courses[i]){
                    answer.add(s);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    void combine(String str, int idx, String menu) {
        int menu_length = menu.length();
        if (menu_length > 1) {
            count_menu.put(menu, count_menu.getOrDefault(menu,0) + 1);

            if(max_count_menu[menu_length] < count_menu.get(menu)){
                max_count_menu[menu_length] = count_menu.get(menu);
                select_courses[menu_length].clear();
            }
            if(max_count_menu[menu_length] <= count_menu.get(menu))select_courses[menu_length].add(menu);
        }
        for (int i = idx+1; i < str.length(); i++) {
            menu += str.charAt(i);
            combine(str, i, menu);
            menu = menu.substring(0, menu.length() - 1);
        }
    }
    @Test
    void test(){
        //Assertions.assertEquals(Arrays.asList("AC", "ACDE", "BCFG", "CDE"),solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},new int[]{2,3,4}));
        Assertions.assertEquals(Arrays.asList("WX", "XY"),solution(new String[]{"XYZ", "XWY", "WXA"},new int[]{2,3,4}));
    }
}
