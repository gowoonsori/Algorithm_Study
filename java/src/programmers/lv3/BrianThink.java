package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BrianThink {
    String sen;

    public String solution(String sentence) {
        StringBuilder answer = new StringBuilder();
        sen = sentence;

        while (sen.length() > 0) {
            /*시작 알파벳이 소문자라면 규칙2 적용 여부 확인*/
            if (sen.charAt(0) >= 'a') {
                if (!checkRule2(sen.charAt(0), sen)) return "invalid";
            }
            /*시작 알파벳이 대문자라면 규칙 1 적용 여부 확인*/
            else if (isUpperCase(sen.charAt(0))) {
                String str = String.valueOf(sen.charAt(0));
                int idx = 0;

                if (sen.length() > 1 && sen.charAt(1) >= 'a') {
                    char ch = sen.charAt(1);
                    if (!checkRule2(ch, sen.substring(1))) {
                        for (idx = 2; idx < sen.length(); idx++) {      //규칙 1에 부합하는지 확인과 단어 끝 idx 찾기
                            if (idx % 2 == 0) {
                                if (isUpperCase(sen.charAt(idx))) str += sen.charAt(idx);
                                else return "invalid";
                            } else if (ch != sen.charAt(idx)) break;
                        }
                        if (!isUpperCase(sen.charAt(idx - 1))) return "invalid"; //규칙 1은 단어 끝이 대문자가 아니라면 fail
                    }
                }
                /*아무규칙 없이 그냥 단어인 경우*/
                else {
                    for (idx = 1; idx < sen.length(); idx++) {
                        if (sen.charAt(idx) >= 'a') break;
                        str += sen.charAt(idx);
                    }
                }
                answer.append(str).append(" ");
                sen = sen.substring(idx);
            }
            /*sentence에 공백이나 특수기호가 올 경우*/
            else {
                return "invalid";
            }
        }
        return answer.deleteCharAt(answer.length() - 1).toString();
    }

    private boolean checkRule2(char ch, String sentence) {
        String[] arr = sentence.substring(1).split(String.valueOf(ch));
        if (arr.length == 1) {       //length가 2이면 마지막 단어인 경우
            if (isUpperCase(arr[0].charAt(sentence.length() - 1))) return false; //단어 끝이 대문자라면 fail
            sen = arr[0];
        } else if (arr.length == 2) {
            if (sentence.charAt(sentence.length() - 1) == ch) return false; //배열 길이가 2인데 단어끝이 소문자가 같다면 fail
            char c = ' ';
            for (char w : arr[0].toCharArray()) {
                if (w >= 'a' && c != w) {
                    c = w;
                    if (arr[1].contains(String.valueOf(c))) return false;
                }
            }
            sen = arr[0] + arr[1];
        } else return false; //length가 0이거나 3이상이면 규칙 2에 해당x
        return true;
    }

    private boolean isUpperCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') return true;
        return false;
    }

    @Test
    void test() {
        Assertions.assertEquals("HELLO WORLD", solution("HaEaLaLaObWORLDb"));
        Assertions.assertEquals("invalid", solution("AxAxAxAoBoBoB"));
        Assertions.assertEquals("invalid", solution("aa"));
        Assertions.assertEquals("invalid", solution("AbAaAbAaCa"));
        Assertions.assertEquals("HELL O WORLD", solution("HaEaLaLObWORLDb"));
    }

    @Test
    void test3() {
        Assertions.assertEquals("I A M", solution("aIaAM"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("HELLO", solution("aHELLOa"));
        Assertions.assertEquals("AAAA AA", solution("AAAAxAbAx"));
        Assertions.assertEquals("HELLO", solution("aHbEbLbLbOa"));
        Assertions.assertEquals("HELLO WORLD", solution("HaEaLaLaObWORLDb"));
        Assertions.assertEquals("HELLOWORLD", solution("HELLOWORLD"));
        Assertions.assertEquals("HELLO WORLD", solution("aHbEbLbLbOacWdOdRdLdDc"));
        Assertions.assertEquals("HELL O WORLD", solution("HaEaLaLObWORLDb"));
        Assertions.assertEquals("AAA", solution("AAA"));
        Assertions.assertEquals("HELLOWORLD", solution("aHELLOWORLDa"));
        Assertions.assertEquals("I A M", solution("aIaAM"));
        Assertions.assertEquals("AO", solution("bAaOb"));
        Assertions.assertEquals("invalid", solution("a"));
        Assertions.assertEquals("invalid", solution("Aa"));
        Assertions.assertEquals("invalid", solution("aA"));
        Assertions.assertEquals("invalid", solution("HaEaLaLaOWaOaRaLaD"));
        Assertions.assertEquals("invalid", solution("abHELLObaWORLD"));
        Assertions.assertEquals("invalid", solution("aHELLOa bWORLDb"));
        Assertions.assertEquals("invalid", solution("TxTxTxbAb"));
        Assertions.assertEquals("invalid", solution("bTxTxTaTxTbkABaCDk"));
        Assertions.assertEquals("invalid", solution("baHELLOabWORLD"));
        Assertions.assertEquals("invalid", solution("A B"));
        Assertions.assertEquals("AAAA BBBB", solution("AxAxAxABcBcBcB"));
        Assertions.assertEquals("BB A", solution("oBBoA"));
        Assertions.assertEquals("AAAA", solution("AxAxAxA"));
        Assertions.assertEquals("HELLO WORLD SIGONG JOA GWFD GWL BB AAAA AAA A"
                , solution("HaEaLaLaObWORLDbSpIpGpOpNpGJqOqAdGcWcFcDdeGfWfLeoBBoAAAAxAxAxAA"));
        Assertions.assertEquals("BA DE A E EEEE", solution("aBcAadDeEdvAvlElmEEEEm"));
        Assertions.assertEquals("A A A B B B", solution("AcAcABaBaB"));
        Assertions.assertEquals("GWFD GWL", solution("aGbWbFbDakGnWnLk"));
        Assertions.assertEquals("X XX X", solution("XcXbXcX"));
        Assertions.assertEquals("invalid", solution("aCaCa"));
        Assertions.assertEquals("invalid", solution("AxAxAxAoBoBoB"));
        Assertions.assertEquals("invalid", solution("xAaAbAaAx"));
        Assertions.assertEquals("invalid", solution("AsCsWsQsQsEEEEEEEEeEeEe"));
        Assertions.assertEquals("A B C D E F GH", solution("ABCaDaEFGbH"));
        Assertions.assertEquals("A B B B AAA", solution("aAaBBBcAeAeAc"));
        Assertions.assertEquals("A B C DEF H I", solution("ABCbDaEaFbHI"));
        Assertions.assertEquals("invalid", solution("AacacaA"));
        Assertions.assertEquals("invalid", solution("AaBcBcBcBcB"));
        Assertions.assertEquals("invalid", solution("aAAA"));
        Assertions.assertEquals("invalid", solution("AAAa"));
        Assertions.assertEquals("invalid", solution("aAbBBbAa"));
        Assertions.assertEquals("invalid", solution("aAbBBbAa"));
        Assertions.assertEquals("invalid", solution("aAAbBbAAa"));
        Assertions.assertEquals("invalid", solution("aAcAbAbAcAcAcAa"));
        Assertions.assertEquals("invalid", solution("acAcAcAa"));
        Assertions.assertEquals("invalid", solution("aAcAcAca"));
        Assertions.assertEquals("A AAA A", solution("AdAeAeAdA"));
        Assertions.assertEquals("invalid", solution("dAAeAd"));
        Assertions.assertEquals("invalid", solution("dAeAAd"));
        Assertions.assertEquals("ABA", solution("cAbBbAc"));
        Assertions.assertEquals("invalid", solution("AbbA"));
        Assertions.assertEquals("invalid", solution("aAaaBa"));
        Assertions.assertEquals("A B", solution("aAacBc"));
        Assertions.assertEquals("A B", solution("AB"));
        Assertions.assertEquals("A B", solution("AcBc"));
        Assertions.assertEquals("A B", solution("aAaB"));
        Assertions.assertEquals("AAAA BBBB", solution("aAbAbAbAacBdBdBdBc"));
        Assertions.assertEquals("AAAA BBBB", solution("AbAbAbABdBdBdB"));
        Assertions.assertEquals("AAAA BBBB", solution("AbAbAbAcBBBBc"));
        Assertions.assertEquals("AAAA BBBB", solution("aAbAbAbAaBdBdBdB"));
        Assertions.assertEquals("AAAA BBBB", solution("aAbAbAbAacBBBBc"));
        Assertions.assertEquals("AAAA BBBB", solution("aAAAAaBdBdBdB"));
        Assertions.assertEquals("AAAA BBBB", solution("aAAAAacBBBBc"));
        Assertions.assertEquals("AAAA BBBB", solution("aAAAAaBdBdBdB"));
        Assertions.assertEquals("AAAA BBBB", solution("aAAAAacBdBdBdBc"));
        Assertions.assertEquals("AAAA BBBB", solution("aAAAAaBdBdBdB"));
        Assertions.assertEquals("AAAA BBBB", solution("AbAbAbAcBdBdBdBc"));
        Assertions.assertEquals("AAAA BBBB", solution("aAAAAaBdBdBdB"));
        Assertions.assertEquals("IM M M", solution("IaMMbMb"));
        Assertions.assertEquals("invalid", solution("AaAaAabBBb"));
        Assertions.assertEquals("A A AA", solution("AaAaAcA"));
        Assertions.assertEquals("A B", solution("aAabBb"));
        Assertions.assertEquals("B HEE", solution("bBbcHdEdEc"));
        Assertions.assertEquals("AA A", solution("AaAA"));
        Assertions.assertEquals("J OOO A", solution("JaOOOaA"));
        Assertions.assertEquals("J O O O A", solution("aJaOOOcAc"));
        Assertions.assertEquals("I AM", solution("IaAMa"));
        Assertions.assertEquals("I A M", solution("aIaAM"));
        Assertions.assertEquals("SIGONG J OOO A", solution("SpIpGpOpNpGJqOOOqA"));
        Assertions.assertEquals("invalid", solution("AxAxAxAoBoBoB"));
        Assertions.assertEquals("HELLO WORLD", solution("HaEaLaLaOWbObRbLbD"));
        Assertions.assertEquals("AAAA B B B", solution("AxAxAxABoBoB"));
        Assertions.assertEquals("B", solution("aBa"));
        Assertions.assertEquals("invalid", solution("baHELLOabWORLD"));
        Assertions.assertEquals("invalid", solution("aAbAba"));
        Assertions.assertEquals("AO", solution("bAaOb"));
        Assertions.assertEquals("A A A B B B BB", solution("AAAaBaBBBbB"));
    }
}
