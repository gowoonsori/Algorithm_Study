#include <string>
#include <vector>
#include <iostream>

using namespace std;

int ans = 100;

void dfs(string word, string target, vector<string> words,vector<bool> &visited,int answer){
    for(int i=0 ; i < words.size(); i++){
        int cnt = 0;
        /*사용하지 않은 단어 중 다른 글자수 check*/
        for(int j=0; j < word.length(); j++){
            if(!visited[i] && word[j] != words[i][j]) cnt++;
        }
        /*1글자만 다르다면*/
        if(cnt == 1){
            if(target == words[i] && ans > answer ){
                ans = answer + 1;
                return;
            }
            visited[i] = true;
            dfs(words[i],target,words,visited,answer+1);    
            visited[i] = false;
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    vector<bool> visited(words.size(),false);
    
    dfs(begin,target,words,visited,answer);
    
    return  (ans == 100) ? 0 : ans;
}