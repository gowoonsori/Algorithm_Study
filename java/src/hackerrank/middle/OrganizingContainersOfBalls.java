package hackerrank.middle;

import java.util.Arrays;
import java.util.List;

public class OrganizingContainersOfBalls {
    public String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        int n = container.size();
        int[] containers = new int[n];
        int[] types = new int[n];

        for(int i = 0; i < n; i++){
            for(int j=0; j < n; j++){
                containers[i] += container.get(i).get(j);  //cnt balls in container
                types[j] += container.get(i).get(j);
            }
        }

        Arrays.sort(containers);
        Arrays.sort(types);

        for(int i=0; i < n; i++){
            if(containers[i] != types[i]) {
                return "Impossible";
            }
        }
        return "Possible";
    }
}
