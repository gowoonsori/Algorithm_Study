#include <string>
#include <vector>
#include <cstdlib>
#include <algorithm>
#include <map>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    map<string,int> m;
    
    for(int i=1; i < s.length() - 1; i++){
        if(s[i] == '{'){
            string num ="";
            for(++i ; s[i] != '}' ; i++){
                if(s[i] == ','){
                    m[num]++;
                    num  = "";
                }
                else num += s[i];
            }
            m[num]++;
        }
    }
   
    /*map의 value로 정렬*/
    vector<pair <int,string>> v;
    for(auto itr = m.begin() ; itr != m.end() ; itr++)
        v.push_back(make_pair(itr->second, itr->first));
    sort(v.begin(), v.end());
    
    /*sort 기본인 오름차순으로 정렬되었기 때문에 뒤부터 삽입*/
    for(int i=v.size()-1; i >= 0 ; i--){
        answer.push_back(stoi(v[i].second));
    }
    
    return answer;
}