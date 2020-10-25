#include <bits/stdc++.h>

using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    int answer = 1;
    rocks.push_back(0);
    rocks.push_back(distance);
    sort(rocks.begin(), rocks.end());
    int l = 1, r = distance;

    while (l <= r) {
        int mid = (l + r) / 2;
        int prev_rock = 0;
        int remove = 0;

        for (int i = 1; i < rocks.size(); i++) {
            int gap = rocks[i] - prev_rock;

            if (gap < mid) {
                remove++;
            } else {
                prev_rock = rocks[i];
            }
        }

        if (remove > n) {
            r = mid - 1;
        } else {
            l = mid + 1;
            answer = mid;
        }
    }
    return answer;
}

int main() {
    int d = 25, n = 2;
    vector<int> rocks = {2, 14, 11, 21, 17};

    cout << solution(d, rocks, n);
}