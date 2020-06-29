#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    bool answer = true;
    int num=x;
    int sum_of_num=0;
    
    for(int i=1; i<=num; i*=10)
        sum_of_num += (num/i)%10;
    
    if(x%sum_of_num != 0) answer=false;
    
    return answer;
}