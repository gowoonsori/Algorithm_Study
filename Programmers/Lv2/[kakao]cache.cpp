#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    if(cacheSize == 0) return 5 * cities.size();
    vector<string> cache_queue(cacheSize,"");
    
    for(int i=0; i < cities.size(); i++){
        transform(cities[i].begin(), cities[i].end(), cities[i].begin(), ::toupper);
        vector<string>::iterator it = find(cache_queue.begin(), cache_queue.end(), cities[i]);
        if( it != cache_queue.end()){
            cache_queue.erase(it);
            cache_queue.push_back(cities[i]);
            answer += 1;
        }
        else{
            cache_queue.erase(cache_queue.begin());
            cache_queue.push_back(cities[i]);
            answer += 5;
        }
    }
    return answer;
}