#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> blocks) {
    queue<int> q;
    int answer = 0;

    for (int i = 0; i < blocks.size(); i++) {
        int l_max = 0, r_max = 0;
        for (int j = 0; j < i; j++) l_max = max(l_max, blocks[j]);
        for (int j = i + 1; j < blocks.size(); j++) r_max = max(r_max, blocks[j]);
        int minToMax = min(l_max, r_max);

        answer += max(0, minToMax - blocks[i]);  //음수라면 기준 block이 높은경우
    }
    return answer;
}

int main() {
    int H, W;
    cin >> H >> W;
    vector<int> blocks(W);

    for (int i = 0; i < W; i++) {
        cin >> blocks[i];
    }

    cout << solution(blocks);

    return 0;
}
