package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Page{
    int index;
    String url;
    int basicScore;
    double linkScore;
    List<Page> link = new ArrayList<>();


    public Page(int index, String url,int basicScore) {
        this.index = index;
        this.url = url;
        this.basicScore = basicScore;
        this.linkScore = 0;
    }

    public void addLinkScore(double linkScore) {
        this.linkScore += linkScore;
    }

    public double getScore() {
        return basicScore + linkScore;
    }

    public void addLink(Page page){
        this.link.add(page);
    }
}

public class MatchingScore {
    Pattern urlPattern = Pattern.compile("<meta[^>]*content=\"(?<url>[^\"]*)\"");
    Pattern linkPattern = Pattern.compile("<a href=\"(?<link>[^\"]*)\"",Pattern.MULTILINE);

    public int solution(String word, String[] pages) {
        int N = pages.length;
        Map<String,Page> map = new HashMap<>();
        List<Page> list = new ArrayList<>();
        Page page;
        /*웹 페이지객체 생성*/
        for(int i=0; i < N; i++){
            String url = findUrl(pages[i]);
             page = new Page(i,url,findWord(pages[i],word));
            map.put(url,page);
            list.add(page);
        }

        /*링크 연결*/
        List<String> linkList;
        for(int i=0; i < N; i++){
            page = list.get(i);
            linkList = findLink(pages[i]);
            for(String link : linkList){
                page.addLink(map.getOrDefault(link,new Page(-1,link,0)));
            }
        }

        /*링크점수 계산*/
        for(int i=0; i < N; i++){
            page = list.get(i);
            for(Page value : map.values()){
                if(value.link.contains(page)){
                    page.addLinkScore((double)value.basicScore/value.link.size());
                }
            }
        }

        list.sort((o1,o2) -> o1.getScore() != o2.getScore() ? Double.compare(o2.getScore(),o1.getScore()) : Integer.compare(o1.index,o2.index));
        return list.get(0).index;
    }
    public String findUrl(String page){
        Matcher matcher = urlPattern.matcher(page);
        matcher.find();
        return matcher.group("url");
    }

    public int findWord(String page,String word){
        int sum=0;
        page = page.toLowerCase();
        word = word.toLowerCase();
        String[] arr = page.split("[^a-z]+");

        for(String str : arr)
            if(str.equals(word))sum++;
        return sum;
    }

    public List<String> findLink(String page){
        List<String> list = new ArrayList<>();
        Matcher matcher = linkPattern.matcher(page);
        while(matcher.find()){
            list.add(matcher.group("link"));
        }
        return list;
    }

    @Test
    void test(){
        String[] pages = new String[]{
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
        };
        Assertions.assertEquals(1,solution("Muzi",pages));
    }

    @Test
    void test1(){
        String[] pages = new String[]{
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
        };
        Assertions.assertEquals(0,solution("blind",pages));

    }

}
