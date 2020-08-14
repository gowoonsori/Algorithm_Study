#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string s)
{
    int answer = 1;
    vector<vector<bool>> v(s.length(),vector<bool> (s.length(),false)); // v[i][j] ==> i 부터 j까지 해당하는 문자열이 펠린드롬이면 true or false


/*DP 이용한 풀이 */

    /*1자리수들은 모두 true*/
    for(int i=0; i < s.length(); i++)
        v[i][i] = true;
    
    /*2자리수의 경우 펠린드롬 검사*/
    for(int i=0; i < s.length()-1; i++){
        if(s[i] == s[i+1]){
            v[i][i+1] = true;
        }
    }

    /*3자리수 이상의 경우 최대 문자열길이 만큼 펠린드롬 검사 */
    for(int i=3; i <= s.length(); i++){
        for(int j = 0 ; j <= s.length() - i ; j++){
            /*i만큼의 자릿수에 해당하는 양끝의 문자열이 같고 
            양끝을 제외한 안의 단어가 펠린드롬이면 해당 단어도 펠린드롬*/
            if(s[j] == s[j+i-1] && v[j+1][j+i-2]){
                v[j][j+i-1] = true;
                answer = i;
            }
        }
    }

    return answer;
}