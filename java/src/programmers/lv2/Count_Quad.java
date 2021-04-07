package programmers.lv2;

public class Count_Quad {
    String
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        zipQuad(arr,0,0,arr.length);
        return answer;
    }

    public void zipQuad(int[][] arr, int x, int y, int size){
        if(size <= 1) {
            answer[arr[y][x]]++;
            return;
        }

        int number = check(arr,x,y,size);
        if(number != -1){
            answer[number]++;
            return;
        }
        size /= 2;
        zipQuad(arr,x,y,size);
        zipQuad(arr,x + size,y,size);
        zipQuad(arr,x,y + size,size);
        zipQuad(arr,x + size,y + size,size);
    }

    public int check(int[][] arr, int x, int y, int size){
        int tmp = arr[y][x];
        for(int i=y; i < y+ size; i++){
            for(int j=x; j < x+ size; j++){
                if(tmp != arr[i][j]) return -1;
            }
        }
        return tmp;
    }
}
