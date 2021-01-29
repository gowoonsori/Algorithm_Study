#include <bits/stdc++.h>

using namespace std;

long long solution(int n, vector<int> works);

int main() {
    int n = 4;
    vector<int> works = {4, 3, 3};
    cout << solution(n, works);
    return 0;
}

long long solution(int n, vector<int> works) {
    long long answer = 0;
    long long sum = 0;
    priority_queue<int> works_queue(works.begin(), works.end());
    // works_queue.emplace(works);
    /*야근 시간보다 works의 합이 작거나 같다면 피로도 0*/
    for (auto work : works) {
        sum += work;
    }
    if (sum <= n) return 0;
    if (works.size() == 1) return n - sum;

    for (int i = n; i > 0; i--) {
        int top = works_queue.top() - 1;
        works_queue.pop();
        works_queue.push(top);
    }

    while (!works_queue.empty()) {
        answer += pow(works_queue.top(), 2);
        works_queue.pop();
    }

    return answer;
}