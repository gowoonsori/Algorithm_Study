#include <iostream>
#include <algorithm>

using namespace std;

bool compare(pair<int,int> a, pair<int,int> b){
	return (double)a.second/(double)a.first > (double)b.second/(double)b.first;
}

int main() {
	vector<pair<int,int>> stuff;
	int N,W,V,MAX,take_weight=0, take_value=0;
	cin >> N;
	
	for(int i = 0; i < N; i++){
		cin >> W >> V;
		stuff.push_back(make_pair(W, V));
	}
	cin >> MAX;
	
	sort(stuff.begin(),stuff.end(),compare);
	
	for(auto k : stuff){
		take_weight += k.first;
		if(take_weight > MAX){
			take_weight -= k.first;
		}
		else{
			take_value += k.second;
		}
	}
	cout << take_value;
	
	return 0;
}