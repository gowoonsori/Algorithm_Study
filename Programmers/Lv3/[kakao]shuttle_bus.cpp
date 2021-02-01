#include <bits/stdc++.h>

using namespace std;

string solution(int n, int t, int m, vector<string> timetable);

int main() {
    vector<string> input = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
                            "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
    vector<string> input2 = {"09:10", "09:09", "08:00"};
    vector<string> input3 = {"00:00"};
    vector<string> input4 = {"09:05", "09:09", "09:13"};

    cout << solution(2, 10, 3, input4);
    return 0;
}

void add_currTime(pair<int, int> &currTime, int t) {
    currTime.second += t;
    if (currTime.second >= 60) {
        currTime.first += 1;
        currTime.second -= 60;
    }
}

string change_currTime_to_string(pair<int, int> currTime) {
    string str = (currTime.first < 10) ? "0" : "";
    str += (to_string(currTime.first) + ":");
    str += (currTime.second < 10) ? "0" : "";
    str += to_string(currTime.second);

    return str;
}

bool isFull(vector<string> timetable, string currTimeStr, int m) {
    int k = 0;
    for (int j = 0; j < timetable.size(); k++, j++) {
        if (timetable[j] > currTimeStr) {
            break;
        }
    }
    return k >= m ? true : false;
}

string solution(int n, int t, int m, vector<string> timetable) {
    string answer = "";
    pair<int, int> currTime = {9, 0};
    string currTimeStr = "09:00";

    sort(timetable.begin(), timetable.end());

    for (int i = n; i > 1; i--) {
        //막차가 아니면 크루들 태워 보내기
        for (int i = 0; i < m; i++) {
            if (timetable[i] <= currTimeStr) {
                timetable.erase(timetable.begin());
            } else
                break;
        }
        add_currTime(currTime, t);
        currTimeStr = change_currTime_to_string(currTime);
    }

    //막차일때 timetable로 계산
    bool flag = isFull(timetable, currTimeStr, m);
    if (flag) {
        int hour = stoi(timetable[m - 1].substr(0, 2));
        int min = stoi(timetable[m - 1].substr(3, 2));

        if (min == 0 && hour == 0) {
            hour -= 1;
            min = 59;
        } else {
            min -= 1;
        }
        answer = change_currTime_to_string({hour, min});
    } else {
        answer = currTimeStr;
    }

    return answer;
}