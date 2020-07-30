#include <iostream>
#include <vector>
#include <bitset>

using namespace std;

int main() {
	int n; cin >> n;
	vector<int>destroy;
	int ram[n];
	
	for(int i=0 ; i < n ; i++){
		int a; cin >> a;
		ram[i] = a;
	}
	
	for(int i=0; i < n; i++){
		bitset<32> num(ram[i]);
		if( num.count() != 1 ) destroy.push_back(i+1);
	}
	
	if(destroy.empty()){
		cout << "0";
	}
	else{
		cout << destroy.size() <<endl;
		for(int n : destroy) cout << n << " ";
	}
	return 0;
}