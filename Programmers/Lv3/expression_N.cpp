#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int N,int number, int cnt,int cal_num, int &answer){
    if(cnt != 0 && cnt > 8) return;
    if(cal_num == number) {
        answer = min(answer, cnt); 
        return;
    }
    
    int num = 0;
    for(int i=0; i + cnt < 9; i++){
        num = 10*num + N;
        dfs(N,number,cnt+i+1,cal_num + num,answer);
        dfs(N,number,cnt+i+1,cal_num - num,answer);
        if(cal_num != 0){
            dfs(N,number,cnt+i+1,cal_num * num,answer);
            dfs(N,number,cnt+i+1,cal_num / num,answer);
        }
    }
}

int solution(int N, int number) {
    int answer = 10;
    dfs(N,number,0,0, answer);
    
    return (answer > 8) ? -1 : answer;
}