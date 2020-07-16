#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    bool first_in_word = true;
    
    for(int i=0; i < s.length(); i++){
        if(s[i] == ' ') {
            first_in_word = true;
            continue;
        }
        if(first_in_word && s[i] > '9' && s[i] > 'Z'){
            s[i] = s[i] - ('a' - 'A');
        }
        else if(!first_in_word && s[i] > '9' && s[i] < 'a' ){
            s[i] = s[i] + ('a' - 'A');
        }
        first_in_word = false;
    }
    return s;
}