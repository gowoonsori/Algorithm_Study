#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

struct compare{
    bool operator()(vector<int> a, vector<int> b){
        return a.at(1) > b.at(1);
    }
};

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    priority_queue<vector<int>,vector<vector<int>>,compare> disk;
    int time = 0, idx=0;
    
    sort(jobs.begin(), jobs.end());
    
    while(idx < jobs.size() || !disk.empty() ){
        if(idx < jobs.size() && jobs[idx][0] <= time){
            disk.push(jobs[idx++]);
            continue;
        }
        else if(disk.empty()){
            time = jobs[idx][0];
        }
        else{
            time += disk.top()[1];
            answer += time - disk.top()[0];
            disk.pop();
        }
    }
    return answer / jobs.size();
}
int main(){
    vector<vector<int>> s ={{0,3},{1,9},{2,6}}; 
    solution(s);
}