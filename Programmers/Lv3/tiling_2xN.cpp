#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;


int solution(int n) {
    int answer = 0;
    vector<int> cases;
    
    for(int i=0; i < n; i++){
        if(cases.empty()) cases.push_back(1);
        else if(cases.size() == 1) cases.push_back(2);
        else cases.push_back( ( cases[i-1] % 1000000007 + cases[i-2] % 1000000007 )  % 1000000007 );
    }
    return cases[n-1];
}