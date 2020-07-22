#include <string>
#include <vector>
#include <iostream>
#include <cstdlib>
#include <algorithm>

using namespace std;

long long cal(long long a, long long b, char op){
    switch(op){
        case '+' :
            return a + b;
        case '-' :
            return a - b;
        case '*' :
            return a * b;
        default :
            return -1;
    }
}

long long solution(string expression) {
    long long answer = 0;
    vector<long long> nums;//expression에 들어 있는 숫자를 저장할 vector
    vector<char> op;       //expression에 들어 있는 연산자 저장할 vector
    vector<int> use_op;    //계산에 사용한 연산자 index값 저장할 vector
    string op_order ="*+-";
    
    /*숫자와 연산자 분리*/
    string num = "";
    for (int i=0; i < expression.size(); i++){
        if(expression[i] >= '0' && expression[i] <= '9')
            num += expression[i];
        else{
            nums.push_back( stoi(num) );
            num =  "";
            op.push_back( expression[i] );
        }
    }
    nums.push_back( stoi(num) );
    
    /*6가지 경우의 수 계산*/
    do{
        vector<char> op_cpy = op;
        vector<long long> nums_cpy = nums;
    
    /* 연산자 는 -,+,* 3개이므로 3번 수행 */
        for(int i=0; i < 3 ; i++){
            /*남아 있는 연산자 계산*/
            for(int j= 0 ;  j < op_cpy.size() ; j++){
                /* 우선 순위해 해당하는 연산자와 현재 연산자가 같다면 계산 */
                if( op_cpy[j] == op_order[i] ) {
                    nums_cpy[j+1] = cal(nums_cpy[j], nums_cpy[j+1], op_cpy[j]);   // 계산에 사용한 숫자 -> (nums_cpy[j] / nums_cpy[j+1])
                    use_op.push_back(j);                                          // 계산결과 값 nums_cpy[j+1]에 저장
                }                                                                 // 계산에 사용한 숫자 중 nums_cpy[j] 를 삭제 하기 위해 index값 저장
            }

            /*계산에 사용한 연산자와 숫자 삭제*/
            for(int j = use_op.size()-1 ; j >= 0; j--){
                op_cpy.erase(op_cpy.begin() + use_op[j]);         //연산자 삭제
                nums_cpy.erase(nums_cpy.begin() + use_op[j]);     // 숫자 삭제
            }
            use_op.clear();   //사용한 연산자 vector clear
        }

        /*nums_cpy의 모든 사용한 숫자는 삭제했으므로
        * nums_cpy[0]만 남아 있고 이 값이 최종 결과 값
        * nums_cpy[0]의 절대값이 answer보다 크다면 값 갱신  */
        if(abs( nums_cpy[0] ) > answer ) answer = abs( nums_cpy[0] );  
        
    }while(next_permutation(op_order.begin(), op_order.end()));
    
    return answer;
}
int main(){
    cout << solution("100-200*300-500+20") <<endl;
}