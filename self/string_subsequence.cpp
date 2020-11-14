/*
문자열이 주어졌을 때, 반복되는 부분 수열이 문자열내에 있는지 찾으시오.
단, 반복되는 부분 수열(부분 문자열과 다름)은 2자 이상의 길이여야 합니다.

example
1.
input : XYBYAXBY
output : true

XB(XBXB),XY(XYXY), YY(YYY), YB(YBYB), YBY(YBYBY)


2.
input : XYBAXB
output : true
XB(XBXB)

3.
input : XBXAXB
output : true
XX(XXX)

4.
input: ABCA
output : false
*/

#include <bits/stdc++.h>

using namespace std;

int main() {
    string str;
    cin >> str;
    int num = 0;

    unordered_map<char, int> map;

    for (int i = 0; i < str.length(); i++) {
        map[str[i]]++;
        if (map[str[i]] < 2) num++;
        if (num == 2) break;
    }
    if (num == 2)
        cout << "true" << endl;
    else
        cout << "false" << endl;
    return 0;
}