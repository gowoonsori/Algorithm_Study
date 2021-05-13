package programmers.lv3;

public class BuildStation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int width = w * 2 + 1;

        int curr = 1;
        int start, end;
        for (int i = 0; i < stations.length; i++) {
            start = stations[i] - w;
            end = stations[i] + w;

            if (curr < start) {
                answer += (start - curr) / width;
                answer += ((start - curr) % width == 0) ? 0 : 1;
            }
            curr = end + 1;
        }

        /*미리 설치된 기지국 이후도 체크해주어야 한다.*/
        if (curr <= n) {
            answer += (n - curr + 1) / width;
            answer += ((n - curr + 1) % width == 0) ? 0 : 1;
        }

        return answer;
    }
}
