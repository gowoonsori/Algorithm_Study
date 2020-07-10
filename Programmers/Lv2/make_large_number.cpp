#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int min;
    int min_idx=0;
    bool rm;
    
    while(k != 0){
        rm = false;
        min=number[0];
        for(int i=0; i<number.size(); i++){
            if(number[i] < number[i+1]){
                number.erase(0+i,1);
                k--;
                rm = true;
                break;
            }
            else if(min > number[i]){ 
                min = number[i];
                min_idx=i;
            }
        }
        if(!rm){
            number.erase(0+min_idx,1);
            k--;
        }
    }
    return number;
}

int main(){
    solution("9939",2);
}