package scofe;

import java.util.*;
class Pair implements Comparable<Pair>{
    Integer x;
    String y;
    public Pair(Integer x, String y) {
        this.x = x;
        this.y = y;
    }
    public Integer first() {
        return x;
    }
    public String second() {
        return y;
    }

    @Override
    public int compareTo(Pair o) {
        return this.y.compareTo(o.y);
    }
}

public class socar {
    static int N;
    static String times[][] = new String[20][2];
    static PriorityQueue<Pair> tokens = new PriorityQueue<>();
    static boolean[] visited = new boolean[21];

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();

        String[] inputs = new String[N];
        for(int i=0; i < N; i++){
            inputs[i] = scanner.nextLine();
        }
        Arrays.sort(inputs);

        for(int i=0; i < N; i++){
            tokens.add( new Pair(i,inputs[i].substring(0,5)));
            tokens.add(new Pair(i, inputs[i].substring(8,13)));
        }
        System.out.println(solution());
    }
    static String solution(){
        String answer = "-1";
        int result=0;

        while(!tokens.isEmpty()){
            int index = tokens.peek().first();
            String time = tokens.peek().second();
            tokens.poll();

            if(!visited[index]){
                result++;
                visited[index] = true;
            }else{
                if(result == N){
                    answer += time;
                }
                result--;
            }

            if(result == N){
                answer = time + " ~ ";
            }
        }
        return answer;
    }
}
