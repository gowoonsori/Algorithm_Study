#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

// abcde/fghij/klmno/pqrst/uvwxy/z
char out_alp(int num)
{
    switch (num)
    {
    case 0:
        return 'a';
    case 1:
        return 'b';
    case 2:
        return 'c';
    case 3:
        return 'd';
    case 4:
        return 'e';
    case 5:
        return 'f';
    case 6:
        return 'g';
    case 7:
        return 'h';
    case 8:
        return 'i';
    case 9:
        return 'j';
    case 10:
        return 'k';
    case 11:
        return 'l';
    case 12:
        return 'm';
    case 13:
        return 'n';
    case 14:
        return 'o';
    case 15:
        return 'p';
    case 16:
        return 'q';
    case 17:
        return 'r';
    case 18:
        return 's';
    case 19:
        return 't';
    case 20:
        return 'u';
    case 21:
        return 'v';
    case 22:
        return 'w';
    case 23:
        return 'x';
    case 24:
        return 'y';
    case 25:
        return 'z';
    default:
        break;
    }
    return 0;
}

bool check(string str)
{
    int i, j = str.length() - 1;
    for (i = 0; i < str.length() / 2; i++, j--)
    {
        if (str[i] != str[j])
            return false;
    }
    return true;
}
void cal(string &str, string r_str, string &ans)
{
    char a2, b2;
    for (int i = str.length() - 1; i >= 0; i--)
    {
        int a = (str[i] - 'a' + r_str[i] - 'a') / 26;
        int b = (str[i] - 'a' + r_str[i] - 'a') % 26;
        if (a == 1)
            str[i - 1] += a;

        ans += out_alp(b);
    }
}

void rule(string &str)
{
    string ans = "";
    string r_str = str;

    reverse(r_str.begin(), r_str.end());
    cal(str, r_str, ans);
    str = ans;
}

int main()
{
    string input;
    cin >> input;

    while (!check(input))
    {
        rule(input);
    }

    cout << input;
    return 0;
}
