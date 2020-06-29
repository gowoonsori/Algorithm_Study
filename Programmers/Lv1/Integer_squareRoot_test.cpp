#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    long long a=sqrt(n);
  
    return pow(a,2) == n ? pow(a+1, 2) : -1;
}