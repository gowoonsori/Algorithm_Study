#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool check_correct(string p){
    vector<string> s;
    
    for(char ch : p){
        if(ch == '(') s.push_back("(");
        else {
            if(s.size() == 0) return false;
            else s.pop_back();
        }
    }
    return true;
}
string rules(string p){
    if(p =="") return p;
    string u="",v="";
    int left = 0,right = 0;
    
    for(int i=0; i < p.size(); i++){
        if(p[i] == '(') left++;
        else right++;
        
        if(left == right ){
            u = p.substr(0,i+1);
            v = p.substr(i+1);
            break;
        } 
    }

    if (check_correct(u)) return u + rules(v);
    else{
        string str = "(" + rules(v) + ")";
        u = u.substr(1,u.length()-2);
        for(int i=0; i < u.length() ; i++){
            if(u[i] == '(') u[i] = ')';
            else u[i] = '(';
        }
        str += u;
        return str;
    }
}

string solution(string p) {
    if(check_correct(p)) return p;
    else return rules(p);
}

int main(){
    cout << solution("()))((()");
}