package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatting {
    Map<String,String> userInfos = new HashMap<>();
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();

        for(String rec : record){
            String[] arr = rec.split(" ");
            if(arr.length > 2){
                userInfos.put(arr[1], arr[2]);
            }
        }

        for(String rec : record){
            String behavior;
            String[] arr = rec.split(" ");
            if(arr[0].equals("Change")) continue;
            else if(arr[0].equals("Enter")) behavior = "들어왔습니다.";
            else behavior = "나갔습니다.";

            answer.add(userInfos.get(arr[1]) + "님이 " + behavior);
        }

        return answer.stream().toArray(String[]::new);
    }
}
