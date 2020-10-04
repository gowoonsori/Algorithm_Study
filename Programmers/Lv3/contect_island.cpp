#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool compare(vector<int> &A, vector<int> &B)
{
    return A[2] < B[2];
}

int find_parent(vector<int> a, int idx)
{
    if (idx == a[idx])
        return idx;
    return find_parent(a, a[idx]);
}

int solution(int n, vector<vector<int>> costs)
{
    int answer = 0;
    sort(costs.begin(), costs.end(), compare);
    vector<int> island(n);
    for (int i = 0; i < n; i++)
        island[i] = i;

    for (auto cost : costs)
    {
        int c0_parent = find_parent(island, cost[0]);
        int c1_parent = find_parent(island, cost[1]);

        if (island[c1_parent] != island[c0_parent])
        {
            island[c1_parent] = island[c0_parent];
            cout << c0_parent << " " << c1_parent << " " << cost[2] << endl;
            answer += cost[2];
        }
    }
    return answer;
}

int main()
{
    vector<vector<int>> a = {{0, 1, 1}, {2, 0, 2}, {2, 1, 5}, {1, 3, 1}, {3, 2, 8}};                       //4
    vector<vector<int>> b = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}; //15
    vector<vector<int>> c = {{0, 1, 1}, {0, 2, 2}, {2, 3, 1}};                                             //4

    cout << solution(5, b) << endl;
}