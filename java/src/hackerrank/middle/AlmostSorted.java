package hackerrank.middle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlmostSorted {
    public void almostSorted(List<Integer> arr) {
        // Write your code here
        int N = arr.size();
        int[] array = arr.stream().mapToInt(Integer::intValue).toArray();
        int[] sorted = arr.stream().sorted().mapToInt(Integer::intValue).toArray();
        List<Integer> diff = compare(array,sorted);

        int firstIndex = diff.get(0);
        int lastIndex = diff.get(diff.size()-1);

        if(diff.isEmpty()){
            System.out.println("yes");
            return;
        }  else if(diff.size() == 2){
            System.out.println("yes\nswap "+ (firstIndex+1) +" "+ (lastIndex+1));
            return;
        }

        reverse(array, firstIndex, lastIndex);
        if(compare(array, sorted).isEmpty()){
            System.out.println("yes\nreverse "+ (firstIndex+1) +" "+ (lastIndex+1) );                return;
        }else{
            System.out.println("no");
            return;
        }
    }
    List<Integer> compare(int[] arr, int[] tmp){
        return IntStream.range(0, arr.length)
                .filter(index -> arr[index] != tmp[index])
                .boxed()
                .collect(Collectors.toList());
    }

   void reverse(int[] arr, int first, int last){
        for(; first < last; first++,last--){
            int tmp = arr[first];
            arr[first] = arr[last];
            arr[last] = tmp;
        }
    }

}
