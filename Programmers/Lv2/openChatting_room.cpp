#include <string>
#include <vector>
#include <sstream>
#include <map>
#include <iostream>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    vector<pair<string,string>> user_behavior;
    map<string,string> user_name;
    
    for(int i=0; i < record.size() ; i++){
        stringstream ss(record[i]);
        string behavior,id,nickname;
        ss >> behavior;  ss >> id;
     
        if(behavior == "Enter"){
            ss >> nickname;
            user_behavior.push_back(make_pair(behavior,id));
            user_name[id] = nickname;
        }      
        else if(behavior == "Leave"){
            user_behavior.push_back(make_pair(behavior,id));
        }
        else {
            ss >> nickname;
            user_name[id] = nickname;
        }  
    }

    for(int i= 0; i < user_behavior.size(); i++){
        string behavior = user_behavior[i].first;
        string id = user_behavior[i].second;
        string nickname = user_name[id];
        string record_str = nickname + "님이 ";
        
        if(behavior == "Enter")       record_str += "들어왔습니다.";
        else if(behavior == "Leave")  record_str += "나갔습니다."; 
        answer.push_back(record_str);
    }
    return answer;
}
int main(){
    vector<string> s = {
        "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
    };
    vector<string> answer = solution(s);
    for(string str : answer)
        cout << str << endl;
}