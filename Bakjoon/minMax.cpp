#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    int min = 1000000, max = -1000000;
    int j;

    for (int i = 0; i < N; i++) {
        cin >> j;
        if (j > max) {
            max = j;
        }
        if (j < min) {
            min = j;
        }
    }
    cout << min << " " << max;
}