#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int word_index=0;
    
    
    for(char c : s){
        if(c==' ') {        
            word_index = 0;
            answer+=' ';
            continue;
        }
        if( word_index % 2 == 0 ) answer+=toupper(c);
        else answer+=tolower(c);
        word_index++;
    }
    return answer;
}