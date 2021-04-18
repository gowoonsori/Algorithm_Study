package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class File implements Comparable<File>{
    String head;
    String number;
    String tail;

    public File() {
        this.tail = "";
        this.head = "";
        this.number = "";
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    @Override
    public int compareTo(File o) {
        if(this.head.equalsIgnoreCase(o.head)){
            if(Integer.parseInt(this.number) == Integer.parseInt(o.number)){
                return 0;
            }
            return Integer.parseInt(this.number) > Integer.parseInt(o.number) ? 1 : -1;
        }
        return this.head.toUpperCase().compareTo(o.head.toUpperCase());
    }

    @Override
    public String toString() {
        return head+number+tail;
    }
}


public class SortFileName {
    List<File> fileList = new ArrayList<>();
    public String[] solution(String[] files) {
        int size = files.length;

        for(int i=0; i < size;i++){
            File file = splitFileName(files[i]);
            fileList.add(file);
        }
        Collections.sort(fileList);

        return fileList.stream().map(File::toString).toArray(String[]::new);
    }

    private File splitFileName(String str){
        File file = new File();
        int index = 0;
        int len = str.length();
        /*head*/
        StringBuilder sb = new StringBuilder();
        for(; index < len; index++){
            if(str.charAt(index) >= '0' && str.charAt(index) <='9'){
                break;
            }
            sb.append(str.charAt(index));
        }
        file.setHead(sb.toString());

        /*NUMBER*/
        sb.setLength(0);
        for(; index<len; index++){
            if(str.charAt(index) > '9' || str.charAt(index) < '0'){
                break;
            }
            sb.append(str.charAt(index));
        }
        file.setNumber(sb.toString());
        /*Tail*/
        file.setTail(str.substring(index));
        return file;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}
                , solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}) );
    }

    @Test
    void test1(){
        Assertions.assertArrayEquals(new String[]{"A-10", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"}
                , solution(new String[]{"A-10","F-5 Freedom Fighter", "B-50 Superfortress" , "F-14 Tomcat"}) );
    }
}
