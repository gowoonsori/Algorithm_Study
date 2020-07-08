#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
#include <iostream>

using namespace std;

string solution(string s) {
    string answer = "";
    vector<int> numbers;
    stringstream ss(s);
    string k;
    
    while(ss >> k) 
        numbers.push_back(stoi(k));
    
    sort(numbers.begin(), numbers.end());
    answer = to_string(numbers.front()) +" "+ to_string(numbers.back());
    return answer;
}

int main(){
    cout << solution("-1 -2 -3 -4") << endl;
}