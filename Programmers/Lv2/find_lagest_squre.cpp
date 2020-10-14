#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> board)
{
    int answer = 0;
    for (int i = 0; i < board.size(); i++)
    {
        if (board[i][0] == 1 || board[0][i] == 1)
        {
            answer = 1;
            break;
        }
    }
    for (int i = 1; i < board.size(); i++)
    {
        for (int j = 1; j < board[0].size(); j++)
        {
            if ((board[i][j] != 0) && (board[i - 1][j - 1] > 0))
            {
                board[i][j] = min(board[i - 1][j - 1], min(board[i - 1][j], board[i][j - 1])) + 1;
                if (board[i][j] > answer)
                    answer = board[i][j];
            }
        }
    }
    return answer * answer;
}
int main()
{
    vector<vector<int>> a = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    cout << solution(a) << endl;
}