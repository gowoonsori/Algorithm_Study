#include <iostream>
#include <bitset>

using namespace std;

int main() {
	int n; cin >> n;
	int b1,b2;
	
	bitset<32> a(n);
	b1 = a.count();
	
	int b = stoi(to_string(n),nullptr,16);
	bitset<32> c(b);
	b2= c.count();

	cout << b1 <<" " << b2;
	
	
	return 0;
}