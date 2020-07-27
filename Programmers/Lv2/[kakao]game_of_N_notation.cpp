#include <string>
#include <iostream>
#include <vector>

using namespace std;

void cal(string &str, int d){
    if (d == 10) { str = "A" + str; }
    else if (d == 11) { str = "B" + str; }
    else if (d == 12) { str = "C" + str; }
    else if (d == 13) {str = "D" + str; }
    else if (d == 14) { str = "E" + str; }
    else if (d == 15) { str = "F" + str; }
    else { str = to_string(d) + str; }
}

string transfor(int num, int n){
    string str = "";
    
    while(true){
        if(num < n) {
            cal(str,num);
            break;
        }
        cal(str, num % n);
        num /= n;
    }
    return str;
}

string solution(int n, int t, int m, int p) {
    string answer = "";
    int number = 0;
    int index = 0;
    
    while(true){
        
        string number_str = transfor(number, n);
       
        for(int i =0; i < number_str.length(); i++,index++){
            if( (index % m) + 1 == p) answer += number_str[i];
            if(answer.length() == t) return answer;
        }
        number++;
    }
    return answer;
}
int main(){
    cout << solution(16,16,2,2);
}