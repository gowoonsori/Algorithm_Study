package scofe.second;

import java.util.*;

class Item{
    int name;
    List<Item> childs;

    public Item(int name) {
        this.name = name;
        childs = new ArrayList<>();
    }
    void putChild(Item item){
        childs.add(item);
    }
}
class MakePackage {
    static int N,Q;
    static Item[] items;
    public static void main(String[] args) {
        List<String> answer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        Q = scanner.nextInt();

        /* Item 생성 */
        items = new Item[N+1];
        for(int i=0; i < N; i++){
            items[i+1] = new Item(i+1);
        }

        /*자식 연결*/
        for(int i=0; i < N-1; i++){
            items[scanner.nextInt()].putChild(items[scanner.nextInt()]);
        }

        for(int i = 0; i < Q; i++){
            int p = scanner.nextInt();
            int e = scanner.nextInt();
            if(isChild(p,e)){
                answer.add("yes");
            }else answer.add("no");
        }
        answer.forEach(s->{System.out.println(s);});
    }
    static boolean isChild(int parent, int child){
        Item item = items[parent];
        if(item.name == child)return true;

        boolean answer = false;
        for(int i =0; i < item.childs.size(); i++){
            if(!answer) answer = isChild(item.childs.get(i).name, child);
            if(answer) break;

        }
        return answer;
    }
}