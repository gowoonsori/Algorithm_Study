#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<int> num;
    string str;
    
    while(n>0){
        num.push_back(n%10);
        n/=10;
    }
    sort(num.begin(),num.end(),greater<int>());
    for(int a: num) str+=to_string(a);
    
    answer = stoll(str);
    
    return answer;
}