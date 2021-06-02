package hackerrank.easy;

public class Operators {
    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        // Write your code here
        double tip, tax,totalCost;

        tip = meal_cost / 100 * tip_percent;
        tax = tax_percent* meal_cost / 100.0 ;
        totalCost = meal_cost + tip + tax;
        long round = Math.round(totalCost);

        System.out.println(totalCost);
        System.out.println(tip);
        System.out.println(tax);
        System.out.println(round);
    }
}
