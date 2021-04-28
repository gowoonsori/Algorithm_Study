package programmers.lv3;

import java.util.HashMap;
import java.util.Map;

class Person {
    String referral;
    int amount;

    public Person(String referral) {
        this.referral = referral;
        this.amount = 0;
    }

    public String getReferral() {
        return referral;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }
}
public class SellToothBrush {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Person> personList = new HashMap<>();

        /*트리 생성*/
        for(int i =0; i < enroll.length; i++){
            personList.putIfAbsent(enroll[i],new Person(referral[i]));
        }

        /*판매 수익 계산*/
        for(int i=0; i < seller.length; i++){
            Person person = personList.get(seller[i]);

            String ref = "start";
            int money = amount[i]*100;
            while(!ref.equals("-")){
                int charge = calculateCharge(money);
                money -= charge;
                person.addAmount(charge);
                ref = person.getReferral();
                person = personList.get(ref);
            }
        }

        /*answer*/
        for(int i=0; i< enroll.length; i++){
            answer[i] = personList.get(enroll[i]).getAmount();
        }
        return answer;
    }
    public int calculateCharge(int money){
        Double d =money * 0.1;
        return d.intValue();
    }
}
