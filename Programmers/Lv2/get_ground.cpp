#include <iostream>
#include <vector>

using namespace std;

int solution(vector<vector<int> > land)
{
    int answer = 0;
    
    for(int i = 0; i < land.size() ; i++){
        int index = 0, max = 0;
        for(int j =0; j < 4; j++){
            if(land[i][j] >= max){
                index = j;
                max = land[i][j];
            }
        }
        if(i != land.size()-1) land[i+1][index] = 0;
        answer += land[i][index];
        cout <<answer <<endl;
    }
    return answer;
}
int main(){
    vector<vector<int>> a={{5,5,5,5},{5,5,5,5},{5,5,5,5}};
    cout << solution(a) <<endl;
}