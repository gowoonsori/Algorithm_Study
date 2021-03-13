package programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class skillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skill_tree : skill_trees){
            if(check_skillTree(skill, skill_tree)) answer++;
        }

        return answer;
    }
    public boolean check_skillTree(String skill, String skill_tree){
        int idx = 0;
        for(char s : skill_tree.toCharArray()){
            if( skill.indexOf(s) == -1 ) continue;
            if( skill.charAt(idx) == s ) idx++;
            else return false;
        }
        return true;
    }

    @Test
    void test(){
        assertEquals(2, solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
        assertEquals(1, solution("BDA",new String[]{"BDA"}));
    }
}
