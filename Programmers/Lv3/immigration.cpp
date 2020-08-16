#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    sort(times.begin(), times.end());
    long long min_time, max_time, avg_time, people;
    
    min_time=1;
    max_time = times.back() * (long long)n;
    
    while(min_time <= max_time){
        people = 0;         
        avg_time = (min_time + max_time) / 2;
        for(auto t : times) people += ( avg_time / t );
        if(people >= n) {
            answer = avg_time; 
            max_time = avg_time - 1;
        }
        else min_time = avg_time + 1;
    }
    return answer;
}