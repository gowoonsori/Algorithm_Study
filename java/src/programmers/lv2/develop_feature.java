package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Feature{
    int progress;
    int speed;
    public Feature(int progress, int speed){this.progress = progress; this.speed = speed;}
    public void develop(){
        this.progress += speed;
    }
    int getProgress(){return this.progress;}
}

public class develop_feature {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Feature> q = new LinkedList<>();
        for(int i=0; i < progresses.length; i++) q.offer(new Feature(progresses[i],speeds[i]));

        int complete = 0;
        boolean isDone = false;
        while(!q.isEmpty()){
            for(Feature f : q) f.develop();
            while(!q.isEmpty() && q.peek().getProgress() >= 100){
                complete++;
                q.poll();
                isDone = true;
            }
            if(isDone){
                answer.add(complete);
                isDone = false;
                complete = 0;
            }
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(Arrays.asList(2,1), solution(new int[]{93,30,55},new int[]{1,30,5}));
    }


}
