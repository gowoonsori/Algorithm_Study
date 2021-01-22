#include <bits/stdc++.h>

using namespace std;

vector<string> input_func();
vector<int> solution(vector<vector<int>> arr);
void DFS(int x, int y, int size, vector<vector<int>> &arr, vector<int> &answer);

int main() {
    vector<vector<int>> arr1 = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
    vector<vector<int>> arr2 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
    solution(arr2);
}

void DFS(int x, int y, int size, vector<vector<int>> &arr, vector<int> &answer) {
    int first = arr[x][y];
    bool sameFirst = true;

    //한칸이라면 숫자세고 바로 return
    if(size == 1){
        answer[arr[x][y]]++;
        return;
    }
    
    /*해당 섹터내 숫자가 모두 동일하다면 flag중 하나는 true */
    for (int i = x; i < x + size; i++) {
        for (int j = y; j < y + size; j++) {
            if (arr[i][j] != first){
                sameFirst = false;
                break; //섹터내 숫자가 다르다면 break
            }
        }
        if(!sameFirst)break; //섹터내 숫자가 다르다면 break
    }

    if (sameFirst) {
        answer[first]++;
        return;
    } 
    else {
        size /= 2;
        DFS(x, y, size, arr, answer);
        DFS(x, y + size, size, arr, answer);
        DFS(x + size, y, size, arr, answer);
        DFS(x + size, y + size, size, arr, answer);
    }
}

vector<int> solution(vector<vector<int>> arr) {
    vector<int> answer(2, 0);
    DFS(0, 0, arr.size(), arr, answer);

    return answer;
}