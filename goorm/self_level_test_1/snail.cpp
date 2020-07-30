#include <iostream>
using namespace std;
int main() {
	double H,D,U,F;
	
	cin >> H >> U >> D >> F;
	
	int day = 0;
	double distance = 0;
	double F_U = ( U * (F / 100.0));
	
	while(distance < H && distance >= 0){
		day++;
		distance += U;
		
		if(distance >= H){
			cout << "Success " << day;
		}
		else if(distance < 0){
			cout << "Failure " << day;
		}
		else{
			distance -= D;
			U -= F_U;
			if(distance < 0){
				cout << "Failure " << day;
			}
		}
	}
	return 0;
}