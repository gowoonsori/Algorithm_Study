package programmers.lv2;

import java.util.*;

class Info{
    String language;
    String occupation;
    String carrer;
    String food;

    public Info(String language, String occupation, String carrer, String food) {
        this.language = language;
        this.occupation = occupation;
        this.carrer = carrer;
        this.food = food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Info)) return false;
        Info info = (Info) o;
        return Objects.equals(language, info.language) && Objects.equals(occupation, info.occupation) && Objects.equals(carrer, info.carrer) && Objects.equals(food, info.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, occupation, carrer, food);
    }
}

public class SearchRanking {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String,List<Integer>> applicant = new HashMap<>();


        for(int i=0; i < info.length; i++){
            String[] word = info[i].split(" ");
            StringBuilder sb = new StringBuilder(word[0]+word[1]+word[2]+word[3]);
            applicant.computeIfAbsent(sb.toString(), s -> new ArrayList<>()).add(Integer.valueOf(word[4]));
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

}
