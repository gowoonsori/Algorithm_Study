package programmers.skillTest1;

public class problem2 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++)
            answer[i] = deSerialize(n,arr1[i], arr2[i]);

        return answer;
    }
    public String deSerialize(int n, int arr1, int arr2){
        String str = "";
        int j;
        for(int i=0; i < n; i++){
            j = (int)Math.pow(2,i);
            if(((arr1 | arr2 ) & j) == j) str ="#" + str;
            else str = " " + str;
        }
        System.out.println(str);
        return str;
    }
}
