package programmers.DevMatching_21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Person {
    String referral;
    int amount;

    public Person(String referral, int amount) {
        this.referral = referral;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }
}

public class Problem3 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Person> personList = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            personList.put(enroll[i], new Person(referral[i], 0));

        }

        for (int i = 0; i < seller.length; i++) {
            Person p = personList.get(seller[i]);

            String ref = "start";
            int money = amount[i]*100;
            while(!ref.equals("-")){
                int charge = calculateCharge(money);
                int m =  money - charge;
                money = charge;
                ref = p.referral;
                p.addAmount(m);
                p = personList.get(ref);
            }
        }

        for(int i = 0; i< enroll.length; i++){
            answer[i] = personList.get(enroll[i]).getAmount();
        }

        return answer;
    }
    public int calculateCharge(int money){
        Double d =money * 0.1;
        return d.intValue();
    }
    @Test
    void test(){
        Assertions.assertArrayEquals(new int[]{360, 958, 108, 0, 450, 18, 180, 1080},
                solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                       new String[]{"young", "john", "tod", "emily", "mary"},
                        new int[]{12, 4, 2, 5, 10}));
    }
}
