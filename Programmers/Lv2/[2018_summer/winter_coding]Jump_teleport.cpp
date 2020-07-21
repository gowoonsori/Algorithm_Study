#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int solution(int n)
{
    bitset<1000> n_bit(n);
    return n_bit.count();
}