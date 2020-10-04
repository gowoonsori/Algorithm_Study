#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <algorithm>

using namespace std;

enum
{
    START,
    END
};

struct log_data
{
    int time;
    int state; //시작, 끝 상태
};

/*시간 으로 오름차순 정렬 / 시간이 같다면 시작이 앞에 와야 최대 처리량 계산*/
bool custom_compare(log_data a, log_data b)
{
    if (a.time != b.time)
    {
        return a.time < b.time;
    }
    else
        return a.state < b.state;
}

int solution(vector<string> lines)
{
    int answer = 0;
    vector<log_data> data;

    for (int i = 0; i < lines.size(); i++)
    {

        // 날짜는 문제에서 중요하지 않으니 date변수로 통일
        int date, hh, mm, ss, ms;
        double work_time;
        sscanf(lines[i].c_str(), "%d-%d-%d %d:%d:%d.%d %lfs", &date, &date, &date, &hh, &mm, &ss, &ms, &work_time);

        ms += ((hh * 60 * 60) + (mm * 60) + ss) * 1000; //초를 밀리초로 변환해서 계산

        data.push_back({ms - (int)(work_time * 1000) + 1, START}); //요청 시작 시간 (끝시간도 처리시간에 포함하므로 +1 )
                                                                   /*요청 끝 시간 + 0.999s 더해주기 
        * 요청이 끝나고 0.999초 안에 그러니까 1초가 되기전에 새로운 요청이 들어온다고 한다면 끝난 요청도 최대 처리요청개수에 포함이 될 수 있다. 
        그러므로 애초에 0.999초를 끝에 더해주고 계산*/
        data.push_back({ms + 999, END});
    }
    //시간을 기준으로 오름차순 정렬하되 같다면 START먼저
    sort(data.begin(), data.end(), custom_compare);

    int max = 0, process = 0;
    for (int i = 0; i < data.size(); ++i)
    {
        if (data[i].state == START)
        {
            ++process;
        }
        else
        {
            --process;
        }
        max = (max > process ? max : process);
    }
    answer = max;
    return answer;
}

int main()
{
    vector<string> a = {
        "2016-09-15 20:59:57.421 0.351s",
        "2016-09-15 20:59:58.233 1.181s",
        "2016-09-15 20:59:58.299 0.8s",
        "2016-09-15 20:59:58.688 1.041s",
        "2016-09-15 20:59:59.591 1.412s",
        "2016-09-15 21:00:00.464 1.466s",
        "2016-09-15 21:00:00.741 1.581s",
        "2016-09-15 21:00:00.748 2.31s",
        "2016-09-15 21:00:00.966 0.381s",
        "2016-09-15 21:00:02.066 2.62s"};
    vector<string> b = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
    cout << solution(a) << endl;
}