package programmers.lv2;

import java.util.Arrays;

public class OhterBit {
    public long[] solution(long[] numbers) {
        int N = numbers.length;
        long[] answer = new long[N];

        for(int i=0; i < N; i++){
            //even
            if(numbers[i] % 2 == 0){
                answer[i] = numbers[i]+1;
                continue;
            }

            //odd
            StringBuilder bit = new StringBuilder(Long.toBinaryString(numbers[i]));
            int zeroIndex = bit.lastIndexOf("0");
            if(zeroIndex == -1){
                bit.insert(1,"0");
            }else{
                bit.setCharAt(zeroIndex,'1');
                bit.setCharAt(zeroIndex+1,'0');
            }

            answer[i] = Long.parseLong(bit.toString(), 2);
        }
        return answer;
    }
    public long[] solution2(long[] numbers) {
        int N = numbers.length;
        long[] answer = Arrays.copyOf(numbers, N);

        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            answer[i] += (answer[i]^numbers[i])>>>2;
        }
        return answer;
    }
}
