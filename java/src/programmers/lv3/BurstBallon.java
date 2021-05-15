package programmers.lv3;

public class BurstBallon {
    public int solution(int[] a) {
        int answer = 2;
        int len = a.length;
        if(len < 3) return len;

        int[] leftMin = new int[len];
        int[] rightMin = new int[len];
        int min = Integer.MAX_VALUE;
        /*i기준 왼쪽 풍선중 최솟값 찾기*/
        for(int i=0; i < len; i++){
            if(min > a[i]) min = a[i];
            leftMin[i] = min;
        }
        /*i기준 오른쪽 풍선중 최솟값 찾기*/
        min = Integer.MAX_VALUE;
        for(int i=len-1; i >= 0 ; i--){
            if(min > a[i]) min = a[i];
            rightMin[i] = min;
        }

        for(int i=1; i < len-1; i++){
            if(leftMin[i] < a[i] && rightMin[i] < a[i]) continue;
            else answer++;
        }
        return answer;
    }
}
