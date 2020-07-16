#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    int answer = 0;
    priority_queue<int> q;
    int j=0;
    
    for(int day = 0; day < k ; day++, stock--){
        if( day == dates[j]) q.push(supplies[j++]);
        if ( stock == 0 ){
            stock = q.top(); q.pop();
            answer++;
        }
    }
    return answer;
}