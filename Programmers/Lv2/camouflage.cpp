#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string,int> hash_map;
    
    for(auto cloth : clothes)
        hash_map[cloth[1]]++;
    
    for(pair <string,int> val : hash_map)
        answer *= val.second+1;
    
    return answer-1;
}