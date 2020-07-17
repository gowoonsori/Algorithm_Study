#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
vector<vector<bool>> visited;

int bfs(int m, int n , vector<vector<int>> picture,int startX, int startY){
    queue<pair<int,int>> q;
    int area = 0;
    int color = picture[startX][startY];
    
    visited[startX][startY] = true;
    q.push(make_pair(startX,startY));
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        area++;
        for(int i=0; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                if(color == picture[nx][ny] && !visited[nx][ny]){
                    q.push(make_pair(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    return area;
}
// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    visited = vector<vector<bool>>(m,vector<bool>(n,false));    
    
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n ; j++){
            if(picture[i][j]!=0 && !visited[i][j]){
                int area = bfs(m,n,picture,i,j);
                number_of_area++;
                if( area > max_size_of_one_area) max_size_of_one_area = area;
            }
        }
    }
    
    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}
int main(){
    vector<vector<int>> picture ={{1,1,1,0},{1,1,1,0},{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}};
    vector<int> answer = solution(6,4,picture);
}