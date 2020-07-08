#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>
#include <algorithm>

using namespace std;

int solution(string numbers) {
    int answer = 0;
    vector<int> num_arr(2);      //0 ~ numbers
    vector<string> prime_num;   
    vector<int> number_cnt(10); 
    
    /*0~numbers의 최댓값 까지 숫자 삽입 */
    sort(numbers.begin(),numbers.end(),greater<int>());
    int number = stoi(numbers);
    for(int i=1; i<number ; i++)
        num_arr.push_back(i+1);

    /*numbers의 사용한 숫자 개수 검사*/
    for( int i=0 ; i  < numbers.size(); i++)
        number_cnt[numbers[i]-'0']++;
    
    /*에라토스테네스의 체를 이용하여 소수 검사*/
    for(int i=0; i <= num_arr.size() ; i++){
        if(num_arr[i] != 0 ) {
            prime_num.push_back(to_string(num_arr[i]));
            answer++;
            for(int j=i+i; j<=num_arr.size() ; j+=i)
                num_arr[j] = 0;
        }
    }
    
    /*소수가 주어진 numbers로 만들 수 있는 소수인지 검사*/
    for( int i=0; i < prime_num.size(); i++ ){
        vector<int> number_cnt_cpy(number_cnt.begin(),number_cnt.end());
        for(int j=0; j < prime_num[i].length(); j++){
            if( --number_cnt_cpy[ prime_num[i].at(j)-'0' ] == -1 ){
                answer--;
                break;
            }
        }
    }
    return answer;
}
int main(){
    cout << solution("0000009");
}