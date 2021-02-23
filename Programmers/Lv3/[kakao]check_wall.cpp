#include <bits/stdc++.h>

using namespace std;

int solution(int n, vector<int> weak, vector<int> dist);

int main() {
    int n = 12;
    vector<int> input1 = {1, 5, 6, 10};
    vector<int> input2 = {1, 2, 3, 4};
    cout << solution(n, input1, input2);

    return 0;
}

int solution(int n, vector<int> weak, vector<int> dist) {
    int answer = 999999;
    int weakSize = weak.size();
    int distSize = dist.size();

    for (int i = 0; i < weakSize; i++) {
        weak.push_back(weak[i] + n);
    }

    do {
        for (int i = 0; i < weakSize; i++) {
            int idx = 0;
            bool flag = true;
            int curr = dist[idx] + weak[i];

            for (int j = i + 1; j < weakSize + i; j++) {
                if (curr < weak[j]) {
                    if (idx + 1 == distSize) {
                        flag = false;
                        break;
                    }
                    curr = weak[j] + dist[++idx];
                }
            }
            if (flag) answer = min(answer, idx + 1);
        }
    } while (next_permutation(dist.begin(), dist.end()));

    return (answer == 999999) ? -1 : answer;
}