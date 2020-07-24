#include <string>
#include <vector>
#include <iostream>
#include <cstdlib>
#include <algorithm>

using namespace std;

int cal(int a, int b){
    return abs(a - b) - 1;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
    int answer = 0;
    bool flag = true;
    string charaters="ACFJMNRT";
    sort(charaters.begin(), charaters.end());
    
    do{
        flag = true;
        
        for(int i=0; i < n; i++){
            int idx1 = charaters.find(data[i][0]);
            int idx2 = charaters.find(data[i][2]);
            
            if(data[i][3] == '=' &&  (cal(idx1,idx2) != data[i][4] -'0')){
                flag = false;
                break;
            }
            else if(data[i][3] == '>' && (cal(idx1,idx2) <= data[i][4] -'0')){
                flag = false;
                break;
                
            }
            else if(data[i][3] == '<' && (cal(idx1,idx2) >= data[i][4] -'0')){
                flag = false;
                break;
            }
        }
        if(flag) answer++;
    }while(next_permutation(charaters.begin(),charaters.end()));
    
    return answer;
}