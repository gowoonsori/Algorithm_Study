#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string m, vector<string> musicinfos) {
    string answer = "(None)";
    string melody = "";
    int max_min = 0;

    /*m --> #처리하여 변환 
    * #붙은 음계는 소문자로 변환 */
     for(int i=0; i< m.length(); i++){
            if(m[i+1] == '#'){
                melody += (m[i] -'A' + 'a');
                i++;
            }
            else melody += m[i];
        }
    
    for(int i=0; i < musicinfos.size(); i++){
        string name="";
        string code="";
        string play_code="";
        int hour = stoi(musicinfos[i].substr(6,2)) - stoi(musicinfos[i].substr(0,2));
        int min = stoi(musicinfos[i].substr(9,2)) - stoi(musicinfos[i].substr(3,2));
        int total_min = min + (hour * 60 );

        int j;
        /* music name split*/
        for(j = 12; musicinfos[i].size(); j++){
            if(musicinfos[i][j] == ',') break;
            name += musicinfos[i][j];
        }
        /*해당 음악의 악보 #처리하면서 split*/
        for(j++;j < musicinfos[i].size(); j++){
            if(musicinfos[i][j+1] == '#'){
                code += (musicinfos[i][j] -'A' + 'a');
                j++;
            }
            else code += musicinfos[i][j] ;
        }
       
       /* 총 재생 시간 만큼의 악보 구하기*/
        for(int k=0; k < total_min ; k++)
           play_code += code[k % code.length()];

        /*재생한 악보에 melody가 포함되어 있으며, 총 재생시간이 긴 음악 저장*/
        if( play_code.find(melody) != -1 && (total_min > max_min)){
            max_min = total_min;
            answer = name;
        }   
    }
    return answer;
}

int main(){
    vector<string> s ={"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
    cout << solution("CC#BCC#BCC#BCC#B",s);
}