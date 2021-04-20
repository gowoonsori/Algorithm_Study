package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ChangeWord {
    boolean[] visited;
    int answer = 50;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        if (!Arrays.asList(words).contains(target)) return 0;

        for (int i = 0; i < words.length; i++) {
            if (checkWord(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, 1, words);
                visited[i] = false;
            }
        }
        return answer;
    }

    private void dfs(String word, String target, int cnt, String[] words) {
        if (word.equals(target)) {
            answer = Math.min(cnt, answer);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && checkWord(word, words[i])) {
                visited[i] = true;
                dfs(words[i], target, cnt + 1, words);
                visited[i] = false;
            }
        }
    }

    private boolean checkWord(String str, String temp) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != temp.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) return false;
        }
        return true;
    }
    @Test
    void test(){
        Assertions.assertEquals(4, solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}
