package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TakePicture {
    public int solution(int n, String[] data) {
        int answer = 0;
        char[] tmp = {'A','C','F','J','M','N','R','T'};

        int idx1, idx2, dist;
        char sign;
        boolean flag;
        do{
            flag = true;
            for(int i =0; i < data.length; i++){
                idx1 = find(tmp, data[i].charAt(0));
                idx2 = find(tmp, data[i].charAt(2));
                dist = data[i].charAt(4) - '0';
                sign = data[i].charAt(3);

                if(sign == '='){
                    if(Math.abs(idx1-idx2)-1 != dist){
                        flag = false;
                        break;
                    }
                }else if(sign == '<'){
                    if(Math.abs(idx1-idx2)-1 >= dist){
                        flag = false;
                        break;
                    }
                }else{
                    if(Math.abs(idx1-idx2)-1 <= dist){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) answer++;
        }while(nextPermutation(tmp));

        return answer;
    }
    private static boolean nextPermutation(char[] list) {
        int i = list.length - 1;
        int j = list.length - 1;


        while(i > 0 && list[i-1] >= list[i]) --i;
        if(i <= 0) return false;	//가장 큰게 0번째 인덱스라면 마지막순열

        while(list[i-1] > list[j]) --j;
        swap(list,i-1,j);

        /** 3. 순서 정해주기 **/
        j = list.length - 1;
        for(; i < j; ++i, --j) {
            swap(list,i,j);
        }
        return true;
    }
    static void swap(char[] list, int i, int j){
        char tmp = list[j];
        list[j] = list[i];
        list[i] = tmp;
    }

    int find(char[]list, char alp){
        for(int i=0; i < list.length; i++){
            if(alp == list[i]) return i;
        }
        return -1;
    }

    @Test
    void test(){
        Assertions.assertEquals(3648, solution(2,  new String[]{"N~F=0", "R~T>2"}));
    }
}
