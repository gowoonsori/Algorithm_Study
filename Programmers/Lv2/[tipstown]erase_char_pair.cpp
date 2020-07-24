#include <iostream>
#include <string>
#include <vector>
using namespace std;

int solution(string s)
{
    int answer = 0;
    vector<char> char_stack;
    
    for(int i=0; i < s.size(); i++){
        if(char_stack.empty()) char_stack.push_back(s[i]);      
        else{
            if( char_stack.back() == s[i] ) char_stack.pop_back();
            else char_stack.push_back(s[i]);
        }
    }
    if(char_stack.empty()) answer = 1; 
    return answer;
}