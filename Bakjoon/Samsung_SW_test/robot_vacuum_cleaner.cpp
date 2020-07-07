#include <iostream>
#include <vector>
#include <string.h> 
#include <stdio.h>

using namespace std;

int N,M;
int room[50][50];
const int moveX[]={-1,0,1,0}, moveY[] = {0,1,0,-1};

void solution(int& answer,int currX, int currY, int way) {
    answer++;
    while (1){
        bool clean = false;
        for (int i = 0; i < 4; i++){
            way = (way + 3) % 4;
            if (!room[currX + moveX[way]][currY + moveY[way]]){
                answer++;
                currX += moveX[way], currY += moveY[way];
                room[currX][currY] = 2;
                clean = true;
                break;
            }
        }
        if (clean == false){
            if (room[currX - moveX[way]][currY - moveY[way]] == 2)
                currX -= moveX[way], currY -= moveY[way];
            else
                return;
        }
    }
}

int main(){
    int answer=0;
    int startX,startY,way;

    cin >> N >> M;
    cin >> startX >> startY >> way;

    memset(room,1,sizeof(room));
    for(int i=0; i<N; i++)
        for(int j=0; j<M; j++)
            cin >> room[i][j];

    solution(answer, startX, startY, way);
    cout << answer ;
    
}