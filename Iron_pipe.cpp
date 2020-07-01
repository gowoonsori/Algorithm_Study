#include <string>
#include <vector>

using namespace std;

int solution(string arrangement) {
    int answer = 0;
    int razer_cnt=0;
    vector<char> stack;
    
    for(int i=0;i<arrangement.size();i++){
        if(arrangement[i]=='(') stack.push_back(arrangement[i]);
        else{
            stack.pop_back();
            if(arrangement[i-1] == '(') answer += stack.size();
            else answer+=1;
        }
    }
    return answer;
}