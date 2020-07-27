#include <string>
#include <vector>
#include <algorithm>

using namespace std;

struct File{
    string name;
    string head;
    string number;
    string tail;
};

File div_part_files(string file){
    string s ="";
    int i;
    File a;
    a.name = file;
    
    transform(file.begin(),file.end(),file.begin(),::toupper);
    for(i=0; i < file.size(); i++){
        if(file[i] >= '0' && file[i] <= '9' ) break;
        else a.head += file[i];
    }
    for(; i < file.size(); i++){
        if(file[i] >= '0' && file[i] <= '9' ) a.number += file[i];
        else break;
    }
    for(; i < file.size(); i++){
        a.tail += file[i];
    }
    return a;
}

bool compare(File a, File b){
    if(a.head == b.head){
        return stoi(a.number) < stoi(b.number);
    }
    else{
        return a.head < b.head;
    }
}

vector<string> solution(vector<string> files) {
    vector<string> answer;
    vector<File> filelist;
    
    for(int i=0; i < files.size(); i++){
        filelist.push_back( div_part_files( files[i] ));
    }
    stable_sort(filelist.begin(), filelist.end(), compare);
    
    for(auto file : filelist){
        answer.push_back(file.name);
    }
    
    return answer;
}