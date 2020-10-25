#include <bits/stdc++.h>
using namespace std;

string str;
int l, len, num, q, k;
vector<int> st;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> str;
    l = str.length();
    for (int i = 0; i < l; i++) {
        num = str[i] - '0';
        if (st.empty()) {
            if (isdigit(str[i])) {
                if (i + 1 < l && str[i + 1] == '(')
                    st.push_back(num);
                else
                    len++;
            }
        } else {
            if (isdigit(str[i])) {
                if (i + 1 < l && str[i + 1] == '(') {
                    k = st.back();
                    st.push_back(num * k);
                    len += q * k;
                    q = 0;
                } else
                    q++;
            } else {
                if (str[i] == '(') continue;
                k = st.back(), st.pop_back();
                len += q * k;
                q = 0;
            }
        }
    }
    cout << len;
}