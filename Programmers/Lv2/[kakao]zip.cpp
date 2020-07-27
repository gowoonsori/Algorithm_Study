#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;

string alp[26] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

vector<int> solution(string msg) {
    vector<int> answer;
    unordered_map<string,int> dic;
    int dic_num;
    for(dic_num =0; dic_num < 26; dic_num++) dic[alp[dic_num]] = dic_num + 1;
    
    for(int i=0; i < msg.length() ; i++){
        string word = "";
        word += msg[i];
        int j;
        for(j = i+1; ; j++){
            if(dic.find(word) == dic.end()) break;
            word += msg[j];
        }
        dic[word] = dic_num + 1;
        dic_num++;
        word.erase(j-i-1);
        i = i + j-i-2;
        answer.push_back(dic[word]);
    } 
    return answer;
}

int main(){
    vector<int> v;
    v = solution("TOBEORNOTTOBEORTOBEORNOT");
    for(int num : v) cout << num << " ";
    cout << endl;
}