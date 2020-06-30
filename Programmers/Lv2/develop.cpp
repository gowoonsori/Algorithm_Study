#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> p_que;
    queue<int> s_que;
    
    int upload_cnt=0;
    int day=1;
    
    for(int i=0; i<progresses.size() ; i++){
        p_que.push(progresses[i]);
        s_que.push(speeds[i]);
    }
    
    while(!p_que.empty()){
        upload_cnt=0;
        int q_size= p_que.size();
        
        for(int i=0; i<q_size ; i++){
            if(p_que.front() + (s_que.front()*day)>=100){
                p_que.pop();
                s_que.pop();
                upload_cnt++;
            }
            else break;
        }
        if(upload_cnt!=0)answer.push_back(upload_cnt);
        day++;
    }
    
    
    return answer;
}