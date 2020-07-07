#include <string>
#include <vector>
#include <iostream>
#include <cstdlib>

using namespace std;
#include <string>
#include <vector>
#include <cstdlib>

using namespace std;

#include <string>
#include <vector>
#include <cstdlib>

using namespace std;

vector<pair<int,int>> keypad = { {0,0},{0,1},{0,2},
                                 {1,0},{1,1},{1,2},
                                 {2,0},{2,1},{2,2},
                                 {3,0},{3,1},{3,2} };

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int left_finger=10, right_finger=12;
    
    for(int i=0; i < numbers.size(); i++){
        if(numbers[i] == 0) numbers[i] = 11;
        
        if(numbers[i] == 1 ||numbers[i] == 4 || numbers[i] == 7 ){
            left_finger = numbers[i];
            answer+="L";
        }
        else if(numbers[i] == 3 ||numbers[i] == 6 || numbers[i] == 9 ){
            right_finger = numbers[i];
            answer+="R";
        }
        else{
            int l_distance = abs(keypad[left_finger-1].first - keypad[numbers[i]-1].first) 
                                + abs(keypad[left_finger-1].second - keypad[numbers[i]-1].second);
            int r_distance = abs(keypad[right_finger-1].first - keypad[numbers[i]-1].first) 
                                + abs(keypad[right_finger-1].second - keypad[numbers[i]-1].second);
            
            if(l_distance > r_distance){
                answer+="R";
                right_finger = numbers[i];
            }
            else if(l_distance < r_distance){
                answer += "L";
                left_finger = numbers[i];
            }
            else{
                if(hand == "right"){
                    answer += "R";
                    right_finger = numbers[i];
                }
                else{
                    answer += "L";
                    left_finger = numbers[i];
                }
            }
        }
    }
    return answer;
}

int main(){
    vector<int> numbers = {7,0,8,2,8,3,1,5,7,6,2};
    cout << solution(numbers,"left");

}