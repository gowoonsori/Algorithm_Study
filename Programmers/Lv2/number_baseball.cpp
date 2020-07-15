#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> baseball) {
    int answer = 0;
    bool possible_answer;  //탐색시 값이 원하는 결과를 만족하는지 검사하기 위한 flag변수


    /* 123 - 987 까지 완전 탐색*/
    for(int i = 123; i <= 987; i++){
        string tmp = to_string(i);       //각 자릿수 별로 비교하기 편하게 string형 으로 치환

        /*0을 제외하고 중복이 허용되지 않는 수만 비교*/
        if(tmp[0] == '0' || tmp[1] == '0' || tmp[2] == '0' 
            || tmp[0] == tmp[1] || tmp[1] == tmp[2] || tmp[0] == tmp[2]) continue;
        possible_answer = true;
        
        /*주어진 baseball 모두 만족하는지 비교*/
        for(int j=0; j < baseball.size(); j++){
            string num = to_string(baseball[j][0]);
            int strike = 0;
            int ball = 0;
            
            /* tmp(i) 와 baseball[j] 의 값 비교하여 strike / ball 값 계산
             * 3자리 숫자 야구 이므로 3번 비교*/
            for(int k = 0; k < 3; k++){
                if ( tmp[k] == num[k] ) strike++;              //자리수가 똑같다면 strike

                else if( tmp[k] == num[ (k + 1) % 3]) ball++;  //자릿수는 같지 않지만
                else if( tmp[k] == num[ (k + 2) % 3]) ball++;  //숫자가 존재한다면 ball
            }

            /*계산한 stike/ball과 baseball에서 주어진 값과 똑같지 않다면 flag변수 false*/
            if( strike != baseball[j][1] || ball != baseball[j][2]){
                possible_answer = false; 
                break;
            }
        }
        if(possible_answer) answer++;    //flag 변수가 true라면 조건을 만족하는 수이므로 answer++
    } 
    return answer;
}