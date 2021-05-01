package programmers.lv3;

public class Rank {
    public int solution(int n, int[][] results) {
        int answer = n;

        boolean[][] board = new boolean[n+1][n+1];
        for(int[] result : results) board[result[0]][result[1]] = true;  // x행 y열 True -> x번 사람이 y사람 이김
        for(int i=1; i <= n; i++){
            for(int j=1; j <= n; j++){
                for(int k=1; k <= n; k++){
                    if(board[j][i] && board[i][k]) board[j][k] = true; //x번 사람이 이긴사람의 이긴사람은 x사람도 이김
                }
            }
        }

        /*n-1번 모두 승패가 기록 안된 경우 check*/
        for(int i=1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                if( !(board[i][j] || board[j][i])){
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}
