#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer(2,0);
    char last_word = words[0][0];
    unordered_map<string,int> word;
    int i;
    
    for(i =0; i < words.size(); i++){
        word[words[i]]++;
        if( word[words[i]] == 1){
            if( last_word == words[i][0]) {
                last_word = words[i][words[i].length()-1];
            }
            else{
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        else{
            answer[0] = i % n + 1;
            answer[1] = i / n + 1;
            break;
        }
    }
    return answer;
}

int main(){
    vector<string> v={"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
    vector<int>a =  solution(3,v);
    cout << a[0] << " " << a[1];
}