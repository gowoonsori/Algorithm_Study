#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int,double> &a, pair<int,double> &b){
    if(a.second != b.second) return a.second > b.second;
    else return a.first < b.first;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<int,double>> fail_rate;
    int num_challenger = stages.size();
    
    for(int i=0; i<N; i++){
        int not_clear=0;
        for(int j=0; j < stages.size(); j++){
            if(i+1 == stages[j]) not_clear++;
        }
        if(num_challenger != 0 ) fail_rate.push_back(make_pair(i+1, (double) not_clear /num_challenger));
        else fail_rate.push_back(make_pair(i+1,0));
        num_challenger -= not_clear;
    }
    sort(fail_rate.begin(),fail_rate.end(),compare);
    
    for(auto num : fail_rate)
        answer.push_back(num.first);
    return answer;
}
int main(){
    vector<int> stages={2,1,2,6,2,4,3,3};
    vector<int> answer = solution(5,stages);
    for(auto num : answer)
        cout << num << " ";
}