package programmers.lv3;

public class InsertAds {
    public String solution(String play_time, String adv_time, String[] logs) {
        int N = logs.length;
        int playTime = timeToSecond(play_time);
        int advTime = timeToSecond(adv_time);
        long[] playCnt = new long[playTime+1];

        /*재생 시작시간에 cnt+1, 종료시간에 -1 */
        for(int i=0; i < N; i++){
            String[] arr = logs[i].split("-");
            playCnt[timeToSecond(arr[0])]++;
            playCnt[timeToSecond(arr[1])]--;
        }

        /*부분 합*/
        for(int i= 1; i <= playTime; i++) playCnt[i] += playCnt[i-1];
        for(int i= 1; i <= playTime; i++) playCnt[i] += playCnt[i-1];

        /*최대 값 구하기*/
        long tmp, max = playCnt[advTime - 1];
        int startTime=0;
        for(int i = 0; i + advTime <= playTime; i++){
            tmp = playCnt[i + advTime] - playCnt[i];
            if(tmp > max){
                max = tmp;
                startTime = i + 1;
            }
        }
        return String.format("%02d:%02d:%02d", startTime / 3600, (startTime/60) % 60, startTime % 60 );
    }
    private int timeToSecond(String time){
        String[] arr = time.split(":");
        return   Integer.parseInt(arr[0]) * 3600
                + Integer.parseInt(arr[1]) * 60
                + Integer.parseInt(arr[2]);
    }
}
