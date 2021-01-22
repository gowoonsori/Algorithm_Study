#include <bits/stdc++.h>

using namespace std;

vector<string> input_func();
int solution(int);

int main() {
    int n = 10;
    solution(n);
}

int solution(int n) {
    int answer = 0;
    vector<int> ternery;

    /*3진법 변환*/
    while (n > 0) {
        ternery.push_back(n % 3);
        n /= 3;
    }

    cout << ternery.size();

    /*10진법 표현*/
    int j = 0;
    for (int i = ternery.size() - 1; i >= 0; i--) {
        answer += ternery[i] * pow(3, j);
        j++;
    }

    return answer;
}