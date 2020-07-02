#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(string a, string b){
    return a+b>b+a;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> num_str;
    
    for(auto num : numbers)
        num_str.push_back(to_string(num));
    
    sort(num_str.begin(),num_str.end(),cmp);
    
    if(num_str.at(0) =="0") return "0";
    for(auto c : num_str)
        answer+=c;
    
    return answer;
}