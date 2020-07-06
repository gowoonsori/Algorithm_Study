#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 1000;
    int div_idx=1;
    string zip;
    
    if(s.size() == 1 ) return 1;
    
    while(div_idx <= s.size()/2 ){
        zip.clear();
        int ch_cnt=1;
        int i = div_idx;
        string ch = s.substr(0,div_idx);
        
        for( ; i <= s.size(); i+=div_idx){
            if(!ch.compare(s.substr(i,div_idx)))  ch_cnt++;
            else{
                if(ch_cnt != 1) zip+=to_string(ch_cnt);
                    zip += ch;
                    ch = s.substr(i,div_idx);
                    ch_cnt=1;
                }
        }
        zip+=s.substr(i-div_idx);    //남은 문자열 붙여주기
        if(answer > zip.length()) answer = zip.length();
        div_idx++;
    }  
    return answer;
}