package programmers.lv2;

public class Ex {
    public static void main(String[] args) {
        int filesize = 0x485a4;
        System.out.println(filesize);
        for(int i=0; i < 4 ; i++){
            int x = filesize >> i*8;
            //System.out.println(x);
            System.out.printf("%x ",x);
        }
    }
}
