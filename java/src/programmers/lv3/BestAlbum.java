package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Play implements Comparable<Play>{
    int index;
    int playCount;

    public Play(int index, int playCount) {
        this.index = index;
        this.playCount = playCount;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Play o) {
        if(this.playCount == o.playCount) return this.index > o.index ? 1 : -1;
        return this.playCount < o.playCount ? 1 : -1;
    }
}

class Genre implements Comparable<Genre>{
    String name;
    int totalPlayCount;

    public Genre(String name) {
        this.name = name;
        this.totalPlayCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addPlayCount(int cnt){
        this.totalPlayCount += cnt;
    }

    @Override
    public int compareTo(Genre o) {
        if(this.totalPlayCount == o.totalPlayCount)
            return 0;
        return this.totalPlayCount < o.totalPlayCount ? 1: -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre = (Genre) o;
        return Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class BestAlbum {
    Map<String, List<Play>> playMap = new HashMap<>();
    List<Genre> genreList = new ArrayList<>();
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        for(int i =0; i < genres.length; i++){
            playMap.putIfAbsent(genres[i], new ArrayList<>());
            playMap.get(genres[i]).add(new Play(i,plays[i]));

            Genre genre = new Genre(genres[i]);
            if(!genreList.contains(genre)) genreList.add(genre);
            genreList.get(genreList.indexOf(genre)).addPlayCount(plays[i]);
        }

        Collections.sort(genreList);

        for(Genre genre : genreList){
            String genreName = genre.getName();
            if(playMap.get(genreName).size() < 2) {
                answer.add(playMap.get(genreName).get(0).getIndex());
                continue;
            }
            Collections.sort(playMap.get(genreName));
            answer.add(playMap.get(genreName).get(0).getIndex());
           answer.add(playMap.get(genreName).get(1).getIndex());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{4,1,3,0}, solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
               new int[]{500, 600, 150, 800, 2500} ));
    }
}
