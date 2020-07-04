#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    long sum=0, num1, num2;
    priority_queue<int,vector<int>,greater<int>> que;
    
    for(int num: scoville)
        que.push(num);
    
    while(que.top() < K ){
        if(que.size() == 1) return -1;
        num1 = que.top(); que.pop();
        num2 = que.top(); que.pop();
        answer++;
        
        que.push(num1 + num2*2);
    }
    
    return answer;
}