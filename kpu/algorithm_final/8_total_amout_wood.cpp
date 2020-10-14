#include <iostream>
#include <vector>

using namespace std;
int M, N;

int main()
{

    cin >> M >> N;
    vector<vector<int>> forest(M, vector<int>(N, 0));
    vector<vector<int>> dp(M, vector<int>(N, 0));

    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> forest[i][j];
            if (j != 0)
            {
                dp[i][j] += dp[i][j - 1] + forest[i][j];
            }
            else
            {
                dp[i][j] += forest[i][j];
            }
        }
    }
    int C;
    cin >> C;
    vector<int> answer(C, 0);

    for (int i = 0; i < C; i++)
    {
        int sx, sy, dx, dy;
        cin >> sy >> sx >> dy >> dx;

        for (int j = sy - 1; j < dy; j++)
        {
            if (sx - 1 != 0)
            {
                answer[i] += dp[j][dx - 1] - dp[j][sx - 2];
                cout << "answer : " << answer[i] << " " << dp[j][sx - 1] << " " << dp[j][dx - 2] << endl;
            }
            else
            {
                answer[i] += dp[j][dx - 1];
                cout << "answer : " << answer[i] << " " << dp[j][sx - 1] << endl;
            }
        }
    }
    for (int i = 0; i < answer.size(); i++)
    {
        cout << answer[i] << endl;
    }

    return 0;
}
