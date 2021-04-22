package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelRoute {
    boolean[] visited;
    List<String> answer = new ArrayList<>();
    int N;
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        visited = new boolean[N];

        for(int i=0; i < N; i++){
            if(tickets[i][0].equals("ICN")){
                visited[i] = true;
                dfs(tickets[i][1],2, tickets,"ICN");
                visited[i] = false;
            }
        }

        answer.sort(Comparator.comparing(String::toString));

        return answer.get(0).split(" ");
    }
    private void dfs(String city,int cnt, String[][] tickets,String route){
        route += " " + city;
        if(cnt == N+1){
            answer.add(route);
            return;
        }
        for(int i=0; i < N; i++){
            if(!visited[i] && tickets[i][0].equals(city)){
                visited[i] = true;
                dfs(tickets[i][1],cnt+1, tickets , route);
                visited[i] = false;
            }
        }
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"},
                solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));
    }

    @Test
    void test1(){
        Assertions.assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"},
                solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
    }
}
