#include <iostream>

using namespace std;

int main() {
	int n; cin >> n;
	
	for(int i=2; i < 10 ; i++){
			for(int j=1; j < 10;){
				for(int k=0; k < n; j++,k++){
					cout << i << " * "<< j << " = " << i*j << " ";
				}
				cout<<endl;
			}
	}
		return 0;
}