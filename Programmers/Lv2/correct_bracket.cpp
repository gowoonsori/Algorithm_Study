#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    vector<char> stack;
    
    for(int i=0; i < s.length() ; i++){
        if( s[i] == '(' )  stack.push_back(s[i]);
        else{
            if(stack.size() == 0 ) return false;
            else stack.pop_back();
        }
    }
    if(stack.size() != 0) return false;
    return answer;
}