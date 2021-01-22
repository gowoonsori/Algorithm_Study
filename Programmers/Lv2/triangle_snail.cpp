#include <bits/stdc++.h>

using namespace std;

enum snail_state { UP = 1, DOWN, RIGHT };

vector<string> input_func();
vector<int> solution(int n);

int main() {
    int n = 4;
    solution(n);
}

vector<string> input_func() {
    vector<string> input;

    string str, item;
    cin >> str;

    return input;
}
vector<int> solution(int n) {
    vector<int> answer;

    // init
    vector<vector<int>> snail(n);
    for (int i = 0; i < n; i++) {
        snail[i].resize(i + 1);
    }

    // run
    int col = 0, row = 0, state = DOWN, num = 1;
    for (int i = 0; i <= n; i++) {
        switch (state) {
            case UP:
                for (int j = i; j < n; j++) {
                    snail[col--][row--] = num++;
                }
                col += 2;
                row++;
                state = DOWN;
                break;

            case DOWN:
                for (int j = i; j < n; j++) {
                    snail[col++][row] = num++;
                }
                col--;
                row++;
                state = RIGHT;
                break;

            case RIGHT:
                for (int j = i; j < n; j++) {
                    snail[col][row++] = num++;
                }
                col--;
                row -= 2;
                state = UP;
                break;

            default:
                break;
        }
    }

    for (int i = 0; i < snail.size(); i++) {
        for (int j = 0; j < snail[i].size(); j++) {
            answer.push_back(snail[i][j]);
            cout << endl << answer.back();
        }
    }

    return answer;
}