package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class CandidateKey {
    Set<Integer> candidateKeys = new HashSet<>();
    public int solution(String[][] relation) {
        int answer = 0;
        int col = relation.length;
        int row = relation[0].length;
        Double combination = Math.pow(2,row);
        boolean isCandidate;
        StringBuilder sb = new StringBuilder();
        Set<String> tuples = new HashSet<>();

        for(int i = 1; i <= combination.intValue(); i++){
            tuples.clear();
            isCandidate = true;
            for(int j = 0; j < col; j++){
                sb.setLength(0);
                for(int k = 0; k < row; k++){
                    if((i & (1 << k)) > 0) sb.append(relation[j][k] + "_");
                }
                if(!tuples.add(sb.toString())){
                    isCandidate = false;
                    break;
                }
            }
            if(isCandidate && check_key(i)) candidateKeys.add(i);
        }
        answer = candidateKeys.size();
        return answer;
    }

    /*이미 존재한 후보키를 포함한 후보키는 후보키에서 제외*/
    private boolean check_key(int combination) {
        for (Integer key : candidateKeys)
            if ((key & combination) == key) return false;

        return true;
    }

    @Test
    void test(){
        Assertions.assertEquals(2,
                solution(new String[][]{
                        {"100","ryan","music","2"},
                        {"200","apeach","math","2"},
                        {"300","tube","computer","3"},
                        {"400","con","computer","4"},
                        {"500","muzi","music","3"},
                        {"600","apeach","music","2"}}));
    }
}
