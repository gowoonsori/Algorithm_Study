#include <iostream>
#include <string>

using namespace std;

int main() {
	string grade;
	cin >> grade;
	
	if(grade.find("12") != -1){
		grade.erase(grade.find("12"),2);
		if(grade.find("21") != -1) cout << "Yes"<<endl;
		else cout << "No"<<endl;
	}
	else {
		cout << "No"<<endl;
    }
	return 0;
}