package programmers.lv2;

import java.util.Arrays;

public class PhoneNumber_list {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        System.out.println(Arrays.toString(phone_book));
        for(int i=0; i < phone_book.length -1; i++){
            if(phone_book[i].length() < phone_book[i+1].length() &&
                    phone_book[i].equals(phone_book[i+1].substring(0,phone_book[i].length()))){
                return false;
            }
        }
        return true;
    }
}
