package hackerrank.easy;

import java.util.List;
import java.util.OptionalDouble;

public class StandardDeviation {
    public void stdDev(List<Integer> arr) {
        // Print your answers to 1 decimal place within this function
        int N = arr.size();
        OptionalDouble optionalDouble = arr.stream().mapToInt(Integer::intValue).average();
        double avg = optionalDouble.getAsDouble();

        double sum = arr.stream().mapToDouble(num -> Math.pow(Math.abs(avg - (double)num),2)).sum();
        System.out.printf("%.1f", Math.sqrt(sum/N));
    }
}
