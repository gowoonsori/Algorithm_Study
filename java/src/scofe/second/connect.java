package scofe.second;

import java.util.*;

class Link {
    String start;
    String end;
    int price;

    public Link(String start, String end, int price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }
}

public class connect {
    static int N;
    static List<Link> worldLink = new ArrayList<>();
    static Set<String> countries = new HashSet<>();

    static Map<String,String> sets = new HashMap<>();
    public static void main(String[] args) {
        int answer=0;
        Scanner scanner = new Scanner(System.in);
        /*input*/
        N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String s = scanner.next();countries.add(s); sets.put(s,s);
            String e = scanner.next();countries.add(e); sets.put(e,e);

            int price = scanner.nextInt();
            worldLink.add(new Link(s, e, price));
        }

        /*무조건 연결되는 경우이기 때문에*/
        if(countries.size()-1 == N){
            for(int i=0; i < N; i++){
                answer+=worldLink.get(i).price;
            }
        }
        else{
            /*solution (Greedy)*/
            Collections.sort(worldLink, (Link o1, Link o2) ->(o1.price > o2.price)?1 : -1);

            for(int i=0; i < N; i++){
                Link link = worldLink.get(i);
                if(find(link.start,link.end)){
                    union(link.start,link.end);
                    answer += link.price;
                }
            }
        }
        System.out.println(answer);
    }
    static boolean find(String s, String e){
        if(sets.get(s).equals(sets.get(e))) return false;
        else return true;
    }

    static void union(String s, String e){
        sets.put(e,sets.get(s));
    }
}
