#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> A, vector<int> B);

int main() {
    vector<int> A = {5, 1, 3, 7};
    vector<int> B = {2, 2, 6, 8};

    cout << solution(A, B);

    return 0;
}

int solution(vector<int> A, vector<int> B) {
    int answer = 0;

    sort(A.begin(), A.end());
    sort(B.begin(), B.end());

    if (A.front() > B.back()) {
        return 0;
    } else if (A.back() < B.front()) {
        return A.size();
    }

    int i = 0;
    int j = 0;
    for (auto a : A) {
        if (A[i] < B[j]) {
            answer++;
            i++;
        }
        j++;
    }

    return answer;
}