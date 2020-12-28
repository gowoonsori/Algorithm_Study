#include <string>
#include <vector>

using namespace std;

int main() { 
    int n;
    vector<vector<int>> results;
    solution(); 
}

int solution(int n, vector<vector<int>> results) {
    int answer = n;
    vector<vector<bool>> g(n + 1, vector<bool>(n + 1, false));

    for (auto a : results) g[a[0]][a[1]] = true;  //이긴 경기 기록

    // floyd-warshall알고리즘으로 i->j 중 i->k, k->j 라면 i->j도 true
    //(즉, i는 k를 이겼고 k는 j를 이겼다면 i는 j를 이긴 것)
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {
                if (g[j][i] && g[i][k]) g[j][k] = true;
            }
        }
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            //둘다 0이라면 경기를 진행하지 않아 순위를 예측할 수 없기 때문에 answer-1
            if ((i != j) && !(g[i][j] || g[j][i])) {
                --answer;
                break;
            }
        }
    }

    return answer;
}