package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


public class find_primeNumber {

    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        permutation("", numbers, set);
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(isPrime(a)) answer++;
        }
        return answer;
    }
    void permutation(String prefix, String str,Set<Integer> set){
        int n = str.length();
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));

        for(int i=0; i < n; i++){
            permutation(prefix+ str.charAt(i), str.substring(0,i) + str.substring(i+1,n), set);
        }
    }

    boolean isPrime(int n){
        if(n == 2) return true;
        else if(n%2 == 0 || n == 1) return false;
        int sqrt = (int)Math.sqrt(n);
        for(int i=3; i <= sqrt; i+=2){
            if(n % i == 0) return false;
        }
        return true;
    }

    @Test
    void test(){
        Assertions.assertEquals(3,solution("17"));
        Assertions.assertEquals(0,solution("000009"));
        Assertions.assertEquals(1,solution("22"));
    }
}
