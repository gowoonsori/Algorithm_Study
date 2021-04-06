package programmers.lv2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int height = 1,width = 1;
        for(int i=1; i <= yellow / 2; i++){
            if(yellow % i != 0)continue;
            width = yellow / i;
            height = i;
            if( height*2 + (width+2)*2 == brown) break;
        }
        answer[0] = width + 2;
        answer[1] = height + 2;
        return answer;
    }
}
