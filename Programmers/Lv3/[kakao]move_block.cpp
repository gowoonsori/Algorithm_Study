#include <bits/stdc++.h>

using namespace std;

typedef vector<vector<int>> vv;
typedef pair<int, int> ii;

struct robot{
    int time;
    int x;
    int y;
    int type;
};

int dx = {-1, 0, 0, 1};
int dy = {0, -1,1,0};

int solution(ii board);

int main() {
    int n;
    vv input = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
    cout << solution(input);
    return 0;
}

bool check(int x, int y, int type, vv &board){
    int N = board.size();

    if(type == 0){
        if(x < 0 || y < 0 || x >= N || y+1 >= N) return false;
        if(board[x][y] || board[x][y+1])return false;
    } else{
        if(x < 0 || y < 0 || x+1 >= N || y >= N) return false;
        if(board[x][y] || board[x+1][y])return false;
    }

}

int solution(vv board) {
    int answer = 0;
    int N = board.size();
    vector<vector<vector<bool>>> visited(N,vector<bool>(N,vector<bool>(N,false)));
    queue<robot> q;

    q.push({0,0,0,0});

    while(!q.empty()){
        robot r= q.front();q.pop();

        if( (r.type == 0 && cur.x == N-1 && cur.y == N-2) || (r.type == 1 && cur.x == N-2 && cur.y == N-1) )
         return r.time;

        for(int i = 0; i < 4; i++){
            int nx = r.x + dx[i];
            int ny = r.y + dy[i];
            if(!check(nx,ny,r.type,board) || visited[nx][ny][r.type]) continue;
            visited[nx][ny][r.type]
        }
    }


    return answer;
}