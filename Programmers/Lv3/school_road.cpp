#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    vector<vector<int>> map(n+1,vector<int>(m+1,0));
    vector<vector<int>> dis(n+1,vector<int>(m+1,0));
    
    for(auto puddle : puddles)
        map[puddle[1]-1][puddle[0]-1] = -1;
    
    dis[0][1] = 1;
     for(int i = 1; i < n; i++){
        for(int j = 1; j < m ; j++){
            if(map[i][j] == -1)
                dis[i][j] = (dis[i-1][j] + dis[i][j-1]) % 10000007;
            else dis[i][j] = 0;
        }
    }
    
    return answer;
}


int main(){
    vector<vector<int>> n = {{2,2}};
    cout << solution(4,3,n);
}