#include <string>
#include <vector>
#include <iostream>

using namespace std;

/*큰 순서대로 삽입 ( 내림차순 )*/
void push_queue(vector<int> &queue, int num){
    if(queue.empty()) queue.push_back(num);
    else{
        vector<int>::iterator it = queue.begin();
        for(int i=0; i < queue.size(); i++){
            if(queue[i] <= num){
                queue.insert(it+i,num);
                return;
            }
        }
        queue.push_back(num);
    }
}

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    vector<int> priority_queue;
    
    for(int i=0; i < operations.size(); i++){
        if(operations[i][0] == 'I' ){
            push_queue(priority_queue,stoi(operations[i].substr(2)));
        }
        else if(operations[i] == "D 1"){
            if(!priority_queue.empty()) priority_queue.erase(priority_queue.begin()); 
        }
        else{
            if(!priority_queue.empty()) priority_queue.pop_back();
        }  
    }

    if(priority_queue.empty()) 
        answer.assign(2,0);
    else {
        answer.push_back(priority_queue.front()); 
        answer.push_back(priority_queue.back()); 
    }
    return answer;
}
int main(){
    	vector<string> op = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        vector<int> ans = solution(op);
        for(auto num : ans) cout << num <<" ";
}