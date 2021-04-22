package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

enum STATE {START(0), END(1);
    int value;
    STATE(int value) { this.value = value; }
    public int getValue() { return value; }
}

class Traffic implements Comparable<Traffic>{
    int time;
    STATE state;

    public Traffic(int time, STATE state) {
        this.time = time;
        this.state = state;
    }

    public STATE getState() {
        return state;
    }

    @Override
    public int compareTo(Traffic o){
        if(this.time == o.time){
            return this.state.getValue() > o.state.getValue() ? 1 : -1;
        }
        return this.time > o.time ? 1 : -1;
    }
}

public class ThanksGivingTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        PriorityQueue<Traffic> q = new PriorityQueue<>();

        for(int i=0; i < lines.length; i++){
            String[] arr = lines[i].split(" ");
            String[] timeArr = arr[1].split(":");
            int hh = Integer.parseInt(timeArr[0] ) * 3600;
            int mm = Integer.parseInt(timeArr[1]) *60;
            int ss = Integer.parseInt(timeArr[2].substring(0,2));
            int ms = Integer.parseInt(timeArr[2].substring(3));
            ms += (hh+mm+ss) *1000;

            int temp = (int) (Double.parseDouble(arr[2].substring(0,arr[2].length()-1)) * 1000);
            int startTime = ms - temp + 1;
            q.add(new Traffic(startTime, STATE.START));
            q.add(new Traffic(ms + 999,STATE.END));
        }

        int cnt = 0;
        while(!q.isEmpty()){
            Traffic traffic = q.poll();
            if(traffic.getState() == STATE.START) cnt++;
            else cnt--;

            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(1, solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
    }
    @Test
    void test1(){
        Assertions.assertEquals(7, solution(new String[]{"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"}));
    }
}
