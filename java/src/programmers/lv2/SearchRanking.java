package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SearchRanking {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String,List<Integer>> applicant = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < info.length; i++){
            String[] word = info[i].split(" ");
            for(int j = 0; j < 16; j++){
                sb.setLength(0);
                if((j & 1) == 1) sb.append(word[0]);
                if((j & 2) == 2) sb.append(word[1]);
                if((j & 4) == 4) sb.append(word[2]);
                if((j & 8) == 8) sb.append(word[3]);
                applicant.computeIfAbsent(sb.toString(), s -> new ArrayList<>()).add(Integer.valueOf(word[4]));
            }
        }

        for (Map.Entry<String, List<Integer>> entry : applicant.entrySet()){
            entry.getValue().sort(null);
        }

        for(int i=0; i < query.length; i++){
            String[] words = query[i].replaceAll("-","").replaceAll(" and ", "").split(" ");
            String key = words[0];
            int score = Integer.valueOf(words[1]);
            List<Integer> list = applicant.getOrDefault(key,new ArrayList<>());

            int start = 0, end = list.size();
            while(start < end){
                int mid = (start + end) / 2;
                if(list.get(mid) < score) start = mid+1;
                else end = mid;
            }
            answer[i] = list.size() - start;
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{1,1,1,1,2,4}, solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}
        , new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}));
    }
}
