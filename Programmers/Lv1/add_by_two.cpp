#include <bits/stdc++.h>

using namespace std;

vector<string> input_func();
vector<int> solution(vector<int> numbers);

int main() {
    vector<int> input = {2, 1, 3, 4, 1};
    solution(input);
}

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    set<int> result;

    for (int i = 0; i < numbers.size(); i++) {
        for (int j = i + 1; j < numbers.size(); j++) {
            result.insert(numbers[i] + numbers[j]);
        }
    }

    while (!result.empty()) {
        answer.push_back(*result.begin());
        result.erase(result.begin());
    }
    /*
    answer.assign(result.begin(),result.end());
    */

    return answer;
}