#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int main() {
	int N, K; cin >> N >> K;
	vector<int> name;
	map<int,int> m;
	vector<int> multitap;
	int answer=0;
	
	for(int i=0; i < K; i++) {
		int a; 
		cin >> a;
		name.push_back(a);
		m[a]++;
	}
	for(int i=0; i < K; i++){
		if(multitap.size() < N ){
			multitap.push_back(name[i]);
			m[name[i]]--;
		}
		else if(find(multitap.begin(),multitap.end(),name[i]) != multitap.end()){
			m[name[i]]--;
			continue;
		}
		else{
			int pull_stuff = multitap[0];
			for(int j=0; j < N-1; j++){
				if( m[multitap[j]] > m[multitap[j+1]] ) pull_stuff = multitap[j+1];
			}
			multitap.erase(find( multitap.begin(), multitap.end(), pull_stuff ));
			multitap.push_back(name[i]);
			m[name[i]]--;
			answer++;
		}
	}
	cout << answer;
	return 0;
}