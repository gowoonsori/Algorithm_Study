package hackerrank.middle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClimbingTheLeaderBoard {
    class Rank implements Comparable<Rank>{
        int rank;
        int score;
        Rank(int score){this.score= score;}
        Rank(int rank,int score){this.rank = rank; this.score= score;}

        @Override
        public boolean equals(Object o){
            if(this == o)return true;
            if(!(o instanceof Rank)) return false;
            Rank rank = (Rank)o;
            return score == rank.score;
        }
        @Override
        public int hashCode(){
            return Objects.hash(score);
        }
        @Override
        public int compareTo(Rank o){
            return this.score - o.score;
        }
    }

    public List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        TreeSet<Rank> set = new TreeSet<>(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();

        int rank=1;
        int rankSize = ranked.size();
        for(int i=0; i < rankSize; i++){
            if(set.add(new Rank(rank,ranked.get(i)))) rank++;
        }

        int playerSize = player.size();
        for(int i=0; i < playerSize; i++){
            if(set.first().score < player.get(i)) result.add(1);
            else if(set.last().score > player.get(i)) result.add(set.last().rank + 1);
            else result.add(set.ceiling(new Rank(player.get(i))).rank);
        }
        return result;
    }
    @Test
    void test(){
        int[] rank = new int[]{100, 90, 90, 80, 75, 60};
        int[] player = new int[]{50, 65,77,90,102};

        List<Integer> result = climbingLeaderboard(Arrays.stream(rank).boxed().collect(Collectors.toList()),
                IntStream.of(player).boxed().collect(Collectors.toList()));
        Assertions.assertArrayEquals(new int[]{6,5,4,2,1}, result.stream().mapToInt(Integer::intValue).toArray());
    }

}
