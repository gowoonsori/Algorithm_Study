#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<pair<int,int>> que;
    priority_queue<int>p_que;
    
    for(int i=0; i<priorities.size() ; i++){
        que.push(make_pair(i,priorities[i]));
        p_que.push(priorities[i]);
    }
  
    while(!que.empty()){
        if(que.front().second == p_que.top()){
            if(que.front().first == location) return answer+1;

            else{
                que.pop();
                p_que.pop();
                answer++;
            }
        }
        else{
            que.push(que.front());
            que.pop();
        }
    }
    
    return answer;
}