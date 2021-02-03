#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> stones, int k);

int main() {
    int n = 3;
    vector<int> input = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
    cout << solution(input, n);
    return 0;
}

int solution(vector<int> stones, int k) {
    int answer = 0;
    int min_max;

    multiset<int> s;

    for (int i = 0; i < k; i++) {
        s.insert(stones[i]);
    }

    min_max = *(--s.end());

    for (int i = k; i < stones.size(); i++) {
        int erase_num = stones[i - k];
        s.erase(s.find(erase_num));
        s.insert(stones[i]);

        min_max = min(min_max, *(--s.end()));
    }

    answer = min_max;
    return answer;
}