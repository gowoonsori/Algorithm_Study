#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<string>> all_routes;

void dfs(vector<vector<string>> tickets, vector<bool> &visited,int cnt,int start, vector<string> &route){
    visited[start] = true;
    route.push_back(tickets[start][0]);
    
    /*모든 티켓을 사용했다면 */
    if(cnt == tickets.size()){
        route.push_back(tickets[start][1]);
        all_routes.push_back(route);
        route.pop_back();
        return ;
    }
    for(int i=0; i < tickets.size(); i++){
        /*방문하지 않았고 현재 항공권의 도착지와 다음 항공권의 출발지가 같다면*/
        if(!visited[i] && tickets[start][1] == tickets[i][0]){
            dfs(tickets,visited,cnt+1,i,route);
            visited[i] = false;
            route.pop_back();
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> route;
    vector<bool> visited;
    int cnt=1;
    
    for(int i=0; i < tickets.size(); i++){
        if(tickets[i][0] == "ICN"){
            visited.assign(tickets.size(),false);
            route.clear();
            dfs(tickets,visited,cnt,i,route);
        }
    }
    sort(all_routes.begin(),all_routes.end());
    return all_routes[0];
}