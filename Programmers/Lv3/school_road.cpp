#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    vector<vector<bool>> map(n+1,vector<bool>(m+1,false));
    vector<vector<int>> dis(n+1,vector<int>(m+1,0));
    
    for(auto puddle : puddles)
        map[puddle[1]][puddle[0]] = true;
    
    dis[0][1] = 1;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m ; j++){
            if(!map[i][j])
                dis[i][j] = (dis[i-1][j] %1000000007 + dis[i][j-1] % 1000000007) % 1000000007;
            else dis[i][j] = 0;
        }
    }
    return dis[n][m] % 1000000007;
}

int main(){
    vector<vector<int>> n = {{2,2}};
    cout << solution(4,3,n);
}