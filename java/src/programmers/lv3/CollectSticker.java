package programmers.lv3;

public class CollectSticker {
    public int solution(int sticker[]) {
        int answer = 0;
        int N = sticker.length;
        if(N == 1) return sticker[0];

        int[] dp1 = new int[N]; dp1[0] = dp1[1] = sticker[0];
        int[] dp2 = new int[N]; dp2[0] = 0; dp2[1] = sticker[1];

        for(int i=2; i < N; i++){
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1] );
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1] );
        }
        answer = Math.max(dp1[N-2], dp2[N-1]);
        return answer;
    }
}
