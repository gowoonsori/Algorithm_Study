#include <string>
#include <vector>

using namespace std;

int solution(string name) {
    int answer = 0;
    int i=0;
    string tmp(name.length(),'A');
    
    while(1){
        tmp[i] = name[i];
        answer += (name[i] <= 'M') ? (name[i] - 'A') : ('Z' - name[i] + 1) ;
        if(!tmp.compare(name)) break;
        
        for(int mov = 1; mov < name.length() ; mov++){
            if(name [(i + mov) % name.length()] != tmp[(i + mov) % name.length()]){
                i =  (i + mov) % name.length();
                answer += mov;
                break;
            }
            else if(name [(i + name.length() - mov) % name.length()] != tmp[(i + name.length() - mov)% name.length()]){
                i = ( i + name.length() - mov ) % name.length();
                answer += mov;
                break;
            }
        }
    }
    return answer;
}