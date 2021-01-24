#include <bits/stdc++.h>

using namespace std;

int solution(vector<string> user_id, vector<string> banned_id);
set<int> selected_userId;

int main() {
    vector<string> user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
    vector<string> banned_id = {"fr*d*", "*rodo", "******", "******"};

    cout << solution(user_id, banned_id);
}

bool compare_id(string &str1, string &str2) {
    if (str1.length() != str2.length()) return false;

    for (int i = 0; i < str1.length(); i++) {
        if ((str2[i] != '*') && (str1[i] != str2[i])) {
            return false;
        }
    }
    return true;
}

void dfs(int idx, int sum, vector<string> &user_id, vector<string> &banned_id, vector<bool> user_visited) {
    if (idx == banned_id.size()) {
        selected_userId.emplace(sum);
        return;
    }

    for (int i = 0; i < user_id.size(); i++) {
        if (user_visited[i]) continue;
        if (compare_id(user_id[i], banned_id[idx])) {
            user_visited[i] = true;
            dfs(idx + 1, sum | (1 << i), user_id, banned_id, user_visited);
            user_visited[i] = false;
        }
    }
}

int solution(vector<string> user_id, vector<string> banned_id) {
    int answer = 0;
    vector<bool> user_visited(user_id.size(), false);

    dfs(0, 0, user_id, banned_id, user_visited);
    answer = selected_userId.size();

    for (auto a : selected_userId) cout << a << endl;
    return answer;
}