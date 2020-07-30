#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n; cin >> n;
	vector<int> A(n); for(int i =0; i < n; i++) cin >> A[i];
	vector<int> B(n); for(int i =0; i < n; i++) cin >> B[i];
	int A_max=0, B_max=0;
	int answer_A=0, answer_B=0;
	
	sort(A.begin(),A.end());
	sort(B.begin(),B.end());
	
	for(int i=1; i < A[n-1] ; i++){
		int cnt = 0;
		for(int j=0; j < n; j++){
			if(A[j] >= i - 2 && A[j] <= i + 2 ) cnt++;
			if(A[j] > i + 2) break;
		}
		if(cnt > A_max) {
			A_max = cnt;
			answer_A = i;
		}
	}
	for(int i=1; i < B[n-1] ; i++){
		int cnt = 0;
		for(int j=0; j < n; j++){
			if(B[j] >= i - 2 && B[j] <= i + 2 ) cnt++;
			if(B[j] > i + 2) break;
		}
		if(cnt > B_max){
		 	B_max = cnt;
			answer_B = i;
		}
	}

	cout << answer_A <<" " << answer_B <<endl;
	cout << ((answer_A > answer_B) ? "good" : "bad");
	
	
	return 0;
}