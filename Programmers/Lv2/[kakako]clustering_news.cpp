#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

void get_set_to_string(string str,vector<string> &str_set){
    for(int i=1; i < str.length(); i++ )
        if(str[i-1] >= 'A' && str[i-1] <= 'Z' && str[i] >= 'A' && str[i] <= 'Z')
            str_set.push_back(str.substr(i-1,2));
}

int solution(string str1, string str2) {
    int answer = 65536;
    vector<string> str1_set;
    vector<string> str2_set;
    vector<string> intersection;
    vector<string> union_set;
    
    transform(str1.begin(),str1.end(),str1.begin(), ::toupper);
    transform(str2.begin(),str2.end(),str2.begin(), ::toupper);
    
    get_set_to_string(str1,str1_set);
    get_set_to_string(str2,str2_set);
    sort(str1_set.begin(),str1_set.end());
    sort(str2_set.begin(),str2_set.end());
    
    intersection.resize(str1_set.size() + str2_set.size());
    auto itr = set_intersection(str1_set.begin(),str1_set.end(), str2_set.begin(), str2_set.end(), intersection.begin());
    intersection.erase(itr,intersection.end());
    
    union_set.resize(str1_set.size() + str2_set.size());
    itr = set_union(str1_set.begin(),str1_set.end(), str2_set.begin(), str2_set.end(), union_set.begin());
    union_set.erase(itr,union_set.end());
    
    if(union_set.size() == 0) return answer;
    return ((double)intersection.size() / (double)union_set.size()) * answer;
}
int main(){
    cout << solution("FRANCE","french")<<endl;
}