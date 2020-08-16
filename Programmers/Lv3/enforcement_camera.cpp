#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 1;
    sort(routes.begin(), routes.end());
    int dis = routes[0][1];
    
    for(auto d : routes){
        if(dis < d[0]){
            answer++;
            dis = d[1];
        }
        if(dis >= d[1]) dis = d[1];
    }
    return answer;
}