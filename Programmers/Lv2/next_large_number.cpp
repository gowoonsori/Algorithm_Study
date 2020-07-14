#include <string>
#include <vector>
#include <bitset>
#include <iostream>

using namespace std;

int count_one(string s){
    int num = 0;
    for(int i=0; i < s.length() ; i++){
        if ( s[i] == '1') num ++;
    }
    return num;
}

int solution(int n) {
    int answer = n;
    int number_of_one_in_n = count_one( bitset<20>(n).to_string() );

    cout << bitset<20>(n).to_string() <<endl;
    while(1){
        answer++;
        int numberof_one_in_answer = count_one(bitset<20>(answer).to_string());
        cout << number_of_one_in_n << " : " <<numberof_one_in_answer<<endl;
        if(numberof_one_in_answer == number_of_one_in_n) break;    
    } 
    return answer;
}
int main(){
    cout << solution(1000000);
}