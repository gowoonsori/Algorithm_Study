/*방의 개수*/

#include <bits/stdc++.h>

using namespace std;

int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

int main() {
    vector<int> arrows = input_func();
    solution(arrows);
}

vector<int> input_func() {
    vector<string> input;

    string str,item;
    cin >> str;

    stringstream ss(str);
    getline(ss,item,',');


}

int solution(vector<int> arrows) {
    int answer = 0;

    map<pair<int, int>, bool> node;
    map<pair<pair<int, int>, pair<int, int>>, bool> edge;

    int x = 0, y = 0;
    node[{x, y}] = true;

    for (int i = 0; i < arrows.size(); i++) {
        for (int j = 0; j < 2; j++) {
            int nx = x + dx[arrows[i]];
            int ny = y + dy[arrows[i]];

            if (node[{nx, ny}] && !edge[{{x, y}, {nx, ny}}]) {
                answer++;
            }
            edge[{{x, y}, {nx, ny}}] = true;
            edge[{{nx, ny}, {x, y}}] = true;
            x = nx;
            y = ny;
            if (!node[{x, y}]) node[{x, y}] = true;
        }
    }

    return answer;
}