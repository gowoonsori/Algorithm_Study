#include <iostream>
#include <map>
#include <vector>
#include <string>

using namespace std;

int main() {
	int n; cin >> n;
	map<int, vector<string>> code;
	bool flag = true;
	string answer ="";
	
	for(int i=0; i < n; i++){
		string c; cin >> c;
		code[c.length()].push_back(c);
	}
	string text, str="";
	cin >> text;
	cout << text <<endl;
	for(int i=0; i < text.length(); i++){
		if(text[i] == ' ' || (i == text.length()-1)) {
			if( code[str.length()].size() == 0){
				flag = false;
				break;
			}
			else{
				if(i == text.length()-1) str += text[i];
				answer += ( code[str.length()].back() + " " );
				code[str.length()].pop_back();
			}
			str="";
		}
		else{
			str += text[i];
		}
	}

	if(flag) cout << answer;
	else{
		for(int i =0; i < text.length(); i++){
			if(text[i] != ' ') cout << "*";
			else cout << " ";
		}
	}
	
	return 0;
}