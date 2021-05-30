package hackerrank.middle;

import java.util.List;

public class FormingAMagicSquare {
    static int[][][] matrix = new int[][][]{
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}}, {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}}, {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}, {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
    };
    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int result = Integer.MAX_VALUE;
        int cnt;
        for(int i =0; i < 8; i++){
            cnt = 0;
            for(int j=0; j < 3; j++){
                for(int k=0; k < 3; k++){
                    if(matrix[i][j][k] == s.get(j).get(k)) continue;
                    cnt += Math.abs(matrix[i][j][k] - s.get(j).get(k));
                }
            }
            result = Math.min(result,cnt);
        }
        return result;
    }
}
