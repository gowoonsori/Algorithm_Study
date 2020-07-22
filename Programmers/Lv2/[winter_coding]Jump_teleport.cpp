#include <iostream>
#include <bitset>

using namespace std;

int solution(int n)
{
    bitset<1000> n_bit(n);
    return n_bit.count();
}
int main(){
    cout << solution(5000);
}