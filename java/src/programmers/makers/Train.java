package programmers.makers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Train {
    public static List<List<Integer>> stations = new ArrayList<>();
    public static int max=0, max_station=-1;

    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = new int[2];
        boolean[] visited = new boolean[n];


        /*LinkedList 형태로 그래프 생성*/
        for(int i = 0; i < n; i++)stations.add(new ArrayList<>());
        for(int i = 0; i < train.length; i++){
            int start = train[i][0] - 1;
            int end = train[i][1] - 1;
            stations.get(start).add(end);
        }

        dfs(0,visited,passenger[0],passenger);

        answer[0] = max_station + 1; answer[1] = max;
        return answer;
    }
    public void dfs(int currStation, boolean[] visited,int cnt,int[] passenger){
        List<Integer> nearStations = stations.get(currStation);

        for(int i=0; i< nearStations.size(); i++){
            if(!visited[nearStations.get(i)]){
                visited[nearStations.get(i)] = true;
                dfs(nearStations.get(i),visited,cnt+passenger[nearStations.get(i)],passenger);
            }
        }
        if(cnt >= max){
            max = cnt;
            max_station = Math.max(max_station, currStation);
        }
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{6,3},solution(6, new int[]{1,1,1,1,1,1}, new int[][]{{1,2},{1,3},{1,4},{3,5},{3,6}}));
    }

    @Test
    void test1(){
        Assertions.assertArrayEquals(new int[]{2,7},solution(3, new int[]{3,4,2}, new int[][]{{1,2},{1,3}}));
    }
}
