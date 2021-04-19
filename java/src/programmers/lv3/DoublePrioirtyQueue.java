package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePrioirtyQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> top = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> bottom = new PriorityQueue<>();

        for(String op : operations){
            String[] arr = op.split(" ");
            if(arr[0].equals("I")){
                top.add(Integer.parseInt(arr[1]));
                bottom.add(Integer.parseInt(arr[1]));
                continue;
            }
            if(arr[1].charAt(0) == '-') removeElement(top,bottom.poll());
            else removeElement(bottom,top.poll());
        }
        if(!top.isEmpty() && !bottom.isEmpty()){
            answer[0] = top.peek();
            answer[1] = bottom.peek();
        }
        return answer;
    }

    private void removeElement(PriorityQueue<Integer> q, Integer item) {
        if(item != null) q.remove(item);
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{0,0}, solution(new String[]{"I 16","D 1"}));
    }
    @Test
    void test1(){
        Assertions.assertArrayEquals(new int[]{16,16}, solution(new String[]{"I 16"}));
    }
    @Test
    void test2(){
        Assertions.assertArrayEquals(new int[]{333,-45}, solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }
    @Test
    void test3(){
        Assertions.assertArrayEquals(new int[]{0,0}, solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
    }
    @Test
    void test5(){
        Assertions.assertArrayEquals(new int[]{5,5}, solution(new String[]{"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"}));
    }
}
