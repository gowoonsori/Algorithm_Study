#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int> > land)
{
    int answer = 0;
    for(int i = 0; i < land.size()-1 ; i++){
        land[i+1][0] += max(land[i][1],max(land[i][2],land[i][3]));
        land[i+1][1] += max(land[i][0],max(land[i][2],land[i][3]));
        land[i+1][2] += max(land[i][0],max(land[i][1],land[i][3]));
        land[i+1][3] += max(land[i][0],max(land[i][1],land[i][2]));
    }
    answer = *max_element(land.end().end() - 4, land.end().end());
    return answer;
}
int main(){
    vector<vector<int>> a={{5,5,5,5},{5,5,5,5},{5,5,5,5}};
    cout << solution(a) <<endl;
}