#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> d, int budget) {
    int answer = 0;
    long sum=0;
    int idx=0;
    
    sort(d.begin(),d.end());
    for(int num : d){
        sum+=num;
        if(sum>budget)break;
        else answer++;
    }
    
    return answer;
}