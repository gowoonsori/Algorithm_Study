#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int M, N;
int K;
int answer = 0, answer_max = 0;
int dir[8][2] = {{-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}, {1, 0}, {0, -1}, {0, 1}};

void bfs(vector<vector<bool>> &map, int S_x, int S_y)
{
    int r = 1; //구름 넓이

    queue<pair<int, int>> q;
    map[S_y][S_x] = true;
    q.push(make_pair(S_x, S_y));
    int x, y, next_x, next_y;
    while (!q.empty())
    {
        x = q.front().first;
        y = q.front().second;
        q.pop();
        for (int i = 0; i < 8; i++)
        {
            next_x = x + dir[i][0];
            next_y = y + dir[i][1];

            if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M && map[next_y][next_x] == false)
            {
                map[next_y][next_x] = true;
                q.push(make_pair(next_x, next_y));
                r++;
            }
        }
    }
    if (K < r)
    {
        answer_max = (answer_max < r) ? r : answer_max;
        answer += 1;
    }
}

int main()
{

    cin >> M >> N;

    vector<vector<bool>> arr(M, vector<bool>(N, true));

    for (int i = 0; i < M; i++)
    {
        int j = 0;
        string str;
        cin >> str;
        for (auto c : str)
        {
            if (c != '#')
            {
                arr[i][j] = false;
            }
            j++;
        }
    }
    cin >> K;

    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (arr[i][j] == false)
            {
                bfs(arr, j, i);
            }
        }
    }
    cout << answer << " " << answer_max;
    return 0;
}
