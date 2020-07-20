#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool check(int m, int n, int &answer,vector<string> &board){
    bool is_check = false;
    vector<vector<bool>> visited(m, vector<bool>(n, false));

    for (int i = 0; i < m - 1; i++){
        for (int j = 0; j < n - 1; j++){
            if( board[i][j] == '0' )continue;
            if ( (board[i][j] == board[i + 1][j]) && (board[i][j] == board[i][j + 1]) && (board[i][j] == board[i + 1][j + 1])){
                visited[i][j] = true;
                visited[i + 1][j] = true;
                visited[i][j + 1] = true;
                visited[i + 1][j + 1] = true;
                is_check = true;
            }
        }
    }
    if(is_check){
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (visited[i][j]){
                    answer++;
                    for (int k = i - 1; k >= 0; k--){
                        board[k + 1][j] = board[k][j];
                        board[k][j] = '0';
                    }
                }
            }
        }
    }
    return is_check;
}

int solution(int m, int n, vector<string> board){
    int answer = 0;
    while ( check(m, n,answer, board) );
  
    return answer;
}

int main(){
    vector<string> s ={"TTTANT","RRFACC","RRRFCC","TRRRAA","TTMMMF","TMMTTJ"};
    cout << solution(6,6,s) <<endl;
}