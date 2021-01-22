#include <bits/stdc++.h>

using namespace std;

vector<string> input_func();
int solution(vector<int> a, vector<int> b);

int main() {
    vector<int> a, b;
    solution(a, b);
}

vector<string> input_func() {
    vector<string> input;

    string str, item;
    cin >> str;

    return input;
}
int solution(vector<int> a, vector<int> b) {
    int answer = 0;

    for (int i = 0; i < a.size(); i++) {
        answer += a[i] * b[i];
    }

    return answer;
}