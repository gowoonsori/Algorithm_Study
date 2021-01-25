#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> solution(int n, vector<vector<int>> build_frame);

int main() {
    vector<vector<int>> input1 = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1},
                                  {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};

    vector<vector<int>> input2 = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1},
                                  {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

    vector<vector<int>> result = solution(5, input2);

    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " ";
        }
        cout << endl;
    }
}

bool install_pillar(int x, int y, vector<vector<int>> &bluePrint) {
    if (y == 0)  //바닥인 경우 설치
        return true;

    else if (bluePrint[x][y - 1] == 0 || bluePrint[x][y - 1] == 2)  //아래에 기둥이 있는 경우 설치
        return true;

    else if ((x != 0 && bluePrint[x - 1][y] >= 1) || bluePrint[x][y] >= 1)  // 아래에 보가 있는 경우 설치
        return true;

    return false;
}

bool install_beam(int x, int y, vector<vector<int>> &bluePrint) {
    if (y == 0)
        return false;  //바닥이면 설치 불가
    else if (bluePrint[x][y - 1] == 0 || bluePrint[x][y - 1] == 2 ||
             (x + 1 < bluePrint.size() && (bluePrint[x + 1][y - 1] == 0 || bluePrint[x + 1][y - 1] == 2)))
        return true;  //기둥이 있다면 설치
    else if ((x > 0 && x < bluePrint.size() - 1) && (bluePrint[x - 1][y] >= 1) && (bluePrint[x + 1][y] >= 1))
        return true;  //양옆에 보가 이어져있다면 설치

    return false;
}

bool check_remove(int x, int y, vector<vector<int>> bluePrint) {
    for (int i = 0; i < bluePrint.size(); i++) {
        for (int j = 0; j < bluePrint.size(); j++) {
            if (bluePrint[i][j] == 2) {
                if (!install_pillar(i, j, bluePrint)) return false;
                if (!install_beam(i, j, bluePrint)) return false;
            } else if (bluePrint[i][j] == 0) {
                if (!install_pillar(i, j, bluePrint)) return false;
            } else if (bluePrint[i][j] == 1) {
                if (!install_beam(i, j, bluePrint)) return false;
            }
        }
    }
    return true;
}

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
    vector<vector<int>> answer;
    vector<vector<int>> bluePrint(n + 1, vector<int>(n + 1, -1));  //-1 : 설치 x, 0: 기둥, 1: 보, 2: 모두 설치

    // build_frame[i][2] == 기둥(0) 보(1)
    // build_frame[i][3] == 삭제(0) 설치(1)
    for (int i = 0; i < build_frame.size(); i++) {
        int x = build_frame[i][0];
        int y = build_frame[i][1];

        if (build_frame[i][3] == 1) {
            if (build_frame[i][2] == 0 && install_pillar(x, y, bluePrint)) {  //기둥 설치
                if (bluePrint[x][y] != -1)
                    bluePrint[x][y] = 2;
                else
                    bluePrint[x][y] = 0;
            } else if (build_frame[i][2] == 1 && install_beam(x, y, bluePrint)) {  //보 설치
                if (bluePrint[x][y] != -1)
                    bluePrint[x][y] = 2;
                else
                    bluePrint[x][y] = 1;
            }
        } else {  //삭제
            vector<vector<int>> bluePrintCpy;
            bluePrintCpy.assign(bluePrint.begin(), bluePrint.end());
            if (build_frame[i][2] == 0)
                bluePrintCpy[x][y] -= 1;  //기둥
            else
                bluePrintCpy[x][y] -= 2;  //보

            if (check_remove(x, y, bluePrintCpy)) {  //삭제해보고 규칙 위배되는지 확인
                bluePrint.assign(bluePrintCpy.begin(), bluePrintCpy.end());
            }
        }
    }

    for (int i = 0; i < bluePrint.size(); i++) {
        for (int j = 0; j < bluePrint[i].size(); j++) {
            if (bluePrint[i][j] == 2) {
                answer.push_back({i, j, 0});
                answer.push_back({i, j, 1});
            } else if (bluePrint[i][j] == 1) {
                answer.push_back({i, j, 0});
            } else if (bluePrint[i][j] == 0) {
                answer.push_back({i, j, 0});
            }
        }
    }
    return answer;
}