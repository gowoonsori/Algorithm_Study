#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int gcd(int a, int b){
    while( b != 0){
        int c = a % b;
        a = b;
        b = c;
    }
    return a;
}
int lcd(int a, int b){
    return a * b / gcd(a,b);
}

int solution(vector<int> arr) {
    int answer = 1;
    
    for( int i= 0; i < arr.size(); i++){
        answer = lcd(arr[i], answer);
    }
    return answer;
}