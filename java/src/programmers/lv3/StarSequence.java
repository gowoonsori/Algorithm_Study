package programmers.lv3;

public class StarSequence {
    public int solution(int[] a) {
        int answer = 0;
        int N = a.length;
        int[] count = new int[N+1];
        for( int i=0; i < N; i++) count[a[i]]++;

        for(int i=0; i < N; i++){
            if(count[i]*2 <= answer) continue;
            int star=0;
            for(int j=0; j < N-1; j++){
                if((a[j] == i || a[j+1] == i) && (a[j] != a[j+1])){
                    star +=2;
                    j++;
                }
            }
            answer = Math.max(answer,star);
        }
        return answer;
    }
}
