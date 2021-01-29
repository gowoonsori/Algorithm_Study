#include <bits/stdc++.h>

using namespace std;

int solution(string dirs);

class line {
   public:
    bool up = false;
    bool down = false;
    bool left = false;
    bool right = false;
};

int main() {
    int n;
    string input = "ULURRDLLU";
    string input2 = "UDU";
    string input3 = "RRRRRRRRRRRRRRRRRRRRRR";
    cout << solution(input3);
    return 0;
}

int solution(string dirs) {
    long long answer = 0;
    line maps[11][11];
    int x = 5, y = 5;

    for (auto ch : dirs) {
        switch (ch) {
            case 'U':
                if (y == 10) break;
                if (!maps[x][y + 1].up) {
                    maps[x][y + 1].up = true;
                    maps[x][y].down = true;
                    answer++;
                }
                y++;
                break;
            case 'D':
                if (y == 0) break;
                if (!maps[x][y - 1].down) {
                    maps[x][y].up = true;
                    maps[x][y - 1].down = true;
                    answer++;
                }
                y--;
                break;
            case 'L':
                if (x == 0) break;
                if (!maps[x - 1][y].left) {
                    maps[x - 1][y].left = true;
                    maps[x][y].right = true;
                    answer++;
                }
                x--;
                break;
            case 'R':
                if (x == 10) break;
                if (!maps[x + 1][y].right) {
                    maps[x + 1][y].right = true;
                    maps[x][y].left = true;
                    answer++;
                }
                x++;
                break;
            default:
                break;
        }
    }
    return answer;
}