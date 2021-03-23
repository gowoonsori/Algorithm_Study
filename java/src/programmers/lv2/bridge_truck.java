package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class bridge_truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int maxSize=0;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i < truck_weights.length; i++){
            int truck = truck_weights[i];
            while(true){
                if(q.size() == bridge_length){
                    maxSize -= q.peek();
                    q.poll();
                } else if(maxSize + truck <= weight){
                    maxSize += truck;
                    q.offer(truck);
                    answer++;
                    break;
                }else{
                    q.offer(0);
                    answer++;
                }
            }
        }
        return answer + bridge_length;
    }

    @Test
    void test(){
        Assertions.assertEquals(8,solution(2,10,new int[]{7,4,5,8}));
    }
}
