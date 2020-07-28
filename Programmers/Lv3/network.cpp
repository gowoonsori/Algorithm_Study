#include <string>
#include <vector>

using namespace std;

void dfs(vector<vector<int>> computers,vector<bool> &visited,int computer,int n){
    visited[computer] = true;
    for(int i=0; i < n; i++){
        if(!visited[i] && computers[computer][i]){
            dfs(computers,visited,i,n);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<bool> visited(n,false);
    
    for(int i=0; i < n; i++){
        if(!visited[i]){
            answer++;
            dfs(computers,visited,i,n);
        }
    }
    return answer;
}