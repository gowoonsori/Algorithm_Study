#include <string>
#include <vector>

using namespace std;

void dfs(vector<int> number, int &ans, int target, int cnt = 0, int sum = 0)
{

    if (cnt == number.size() - 1)
    {
        if (sum + number[cnt] == target)
            ans++;
        if (sum - number[cnt] == target)
            ans++;
        return;
    }
    dfs(number, ans, target, cnt + 1, sum + number[cnt]);
    dfs(number, ans, target, cnt + 1, sum - number[cnt]);
}

int solution(vector<int> numbers, int target)
{
    int answer = 0;

    dfs(numbers, answer, target);

    return answer;
}