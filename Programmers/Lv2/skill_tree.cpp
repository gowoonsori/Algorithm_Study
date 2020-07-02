#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    map<char,int> skill_order;
    int cnt=1;
    
    for(int i=0; i<skill.length(); i++)
       skill_order.insert(pair<char,int>(skill[i],i+1));


    for(auto str : skill_trees){
        answer++;
        cnt=1;
        for(int i=0; i<str.length(); i++){
            if(skill_order[str[i]] == cnt) cnt++;
            else if(skill_order[str[i]] > cnt) {
                answer--;
                break;
            }
        }
    }
    
    return answer;
}