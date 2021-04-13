package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JustThatNowSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = changePoundKey(m);
        int min,hour,time,maxTime=0;
        String name,melody;

        for(String musicinfo : musicinfos){
            String[] info = musicinfo.split(",");
            min = Integer.parseInt(info[1].substring(3)) - Integer.parseInt(info[0].substring(3));
            hour = Integer.parseInt(info[1].substring(0,2)) - Integer.parseInt(info[0].substring(0,2));
            time = hour * 60 + min + 1;

            if(time > maxTime){
                name = info[2];
                melody = changePoundKey(info[3]);
                StringBuilder sb = new StringBuilder();
                for(int i=0; i < time; i++) sb.append(melody.charAt(i % melody.length()));
                if(sb.indexOf(m) >= 0){
                    maxTime = time;
                    answer = name;
                }
            }
        }
        return answer;
    }

    private String changePoundKey(String melody){
        StringBuilder sb = new StringBuilder();
        int size = melody.length();
        for(int i=0; i < size; i++){
            if(i != size-1 && melody.charAt(i+1) == '#'){
                sb.append((char)(melody.charAt(i) + 32));
                i++;
                continue;
            }
            sb.append(melody.charAt(i));
        }
        return sb.toString();
    }
    @Test
    void test1(){
        Assertions.assertEquals("HELLO", solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
    @Test
    void test2(){
        Assertions.assertEquals("FOO", solution("CC#BCC#BCC#BCC#B"	, new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
    }
}
