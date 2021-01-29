#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> solution(int n);
vector<vector<int>> answer;

int main() {
    int n = 3;
    solution(n);
    return 0;
}

void hanoi(int start, int end, int remainder, int n) {
    if (n == 0) return;
    hanoi(start, remainder, end, n - 1);
    answer.push_back({start, end});
    hanoi(remainder, end, start, n - 1);
}

vector<vector<int>> solution(int n) {
    hanoi(1, 3, 2, n);
    return answer;
}