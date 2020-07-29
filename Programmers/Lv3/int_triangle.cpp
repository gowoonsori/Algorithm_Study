#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    vector<vector<int>> add_value(triangle.size(), vector<int>(triangle.size()+2, 0));
    answer = add_value[0][0] = triangle[0][0];
    
    for(int i = 1 ; i < triangle.size(); i++){
        for(int j = 0; j < triangle[i].size(); j++){
            if(j == 0 ){
                add_value[i][j] = triangle[i][j] + add_value[i-1][j]; 
            }
            else if( j == triangle[i].size() - 1){
                add_value[i][j] = triangle[i][j] + add_value[i-1][j-1];
            }
            else{
                add_value[i][j] = max(add_value[i-1][j - 1] , add_value[i-1][j]) + triangle[i][j];
            }
        }
    }
    sort(add_value.back().begin(), add_value.back().end(), greater<int>());
    return add_value.back()[0];
}