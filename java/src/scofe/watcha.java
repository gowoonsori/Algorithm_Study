package scofe;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *입력
 4.0 3.0 2.1 4.3 5.0
 2 3
 WYO
 YYO
 ABC
 DCE

 출력
 D 4.3 1 0
 B 3.0 0 1
 C 2.1 1 1
 E 5.0 1 2
 C 2.1 0 2
 *
 *
 */



public class watcha {
    static int N,M;
    static float genre_score[] = new float[5]; //A,B,C,D,E
    static PriorityQueue<Pairs> q = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*input*/
        for(int i=0; i< 5; i++)
            genre_score[i] = scanner.nextFloat();
        N = scanner.nextInt();
        M = scanner.nextInt(); scanner.nextLine();

        char contents[][] = new char[N][M];
        for(int i=0; i< N; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < M; j++)
                contents[i][j] = s.charAt(j);
        }
        char contents_genre[][] = new char[N][M];
        for(int i=0; i< N; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < M; j++)
                contents_genre[i][j] = s.charAt(j);
        }

        /*solution*/
        for(int i=0; i< N; i++){
            for(int j=0; j<M; j++){
                if(contents[i][j] != 'W'){
                    char g = contents_genre[i][j];
                    q.add(new Pairs(contents[i][j],new Info(j,i,g,genre_score[g-'A'])));
                }
            }
        }
        while(!q.isEmpty()){
            Info info = q.peek().info;
            System.out.println(info.genre+ " "+ info.score+" " +info.y+" "+info.x);
            q.poll();
        }
    }
}

class Info {
    int x;
    int y;
    char genre;
    float score;

    public Info(int x,int y,char genre,float score){
        this.x = x;
        this.y=y;
        this.genre= genre;
        this.score = score;
    }
}

class Pairs implements Comparable<Pairs>{
    char open;
    Info info;

    public Pairs(char open, Info info) {
        this.open = open;
        this.info = info;
    }
    public char first() {
        return open;
    }
    public Info second() {
        return info;
    }

    @Override
    public int compareTo(Pairs o) {
        if(this.open == 'Y'){
            if(o.open == 'Y')
                return this.info.score > o.info.score ? -1 : 1;
            return -1;
        }
        else{
            if(o.open == 'Y') return 1;
            return this.info.score > o.info.score ? -1 : 1;
        }
    }
}
