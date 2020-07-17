#include <vector>
#include <map>

using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    map<int,int> pocketmon;
    
    for(int i=0; i < nums.size() ; i++){
        pocketmon[nums[i]]++;
        if(pocketmon[nums[i]] == 1) answer++;
        if(answer >= nums.size() / 2) break;
    }
    return answer;
}