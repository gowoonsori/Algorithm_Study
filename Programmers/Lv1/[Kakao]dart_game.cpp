#include <string>
#include <cstdlib>
using namespace std;

int solution(string dartResult) {
    int answer = 0;
    int score[3];
    int idx=0;
    
	for (int i = 0; i < dartResult.length(); i++) {
        if(dartResult[i]>='0' && dartResult[i]<='9'){
            if (dartResult[i + 1] == '0') {
				score[idx++]=10;
				i++;
			}	
            else score[idx++]=stoi(&dartResult[i]);
        }
        else{
            if (dartResult[i] == 'D') score[idx - 1] *= score[idx - 1];
		    else if (dartResult[i] == 'T') score[idx - 1] *= score[idx - 1] * score[idx - 1];
            else if (dartResult[i] == '*'){
                score[idx-1]*=2;
                if(idx>1)score[idx-2]*=2;
            }
            else if (dartResult[i] == '#') score[idx-1] *= -1;
        }
    }
    for(int i=0; i<3 ; i++)
        answer+=score[i];
    return answer;
}