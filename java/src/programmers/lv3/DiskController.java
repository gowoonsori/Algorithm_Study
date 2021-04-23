package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

class Job implements Comparable<Job>{
    int startTime;
    int jobTime;

    public Job(int startTime, int jobTime) {
        this.startTime = startTime;
        this.jobTime = jobTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getJobTime() {
        return jobTime;
    }

    @Override
    public int compareTo(Job o) {
        return this.jobTime - o.jobTime;
    }
}

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        Arrays.sort(jobs,(o1,o2) ->  {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        } );

        PriorityQueue<Job> q = new PriorityQueue<>();
        int time, index = 0;
        q.add(new Job(jobs[index][0],jobs[index][1]));
        time = jobs[index++][0];

        while(!q.isEmpty()){
            Job job = q.poll();
            time += job.getJobTime();
            answer += time - job.getStartTime();

            for(; index < n; index++){
                if(jobs[index][0] > time) break;
                q.add(new Job(jobs[index][0],jobs[index][1]));
            }
            if(q.isEmpty() && index != n){
                time = jobs[index][0];
                q.add(new Job(jobs[index][0],jobs[index++][1]));
            }
        }
        return answer / n;
    }
    @Test
    void test(){
        Assertions.assertEquals(9,solution(new int[][]{{0,3},{1,9},{2,6}}));
    }
}
