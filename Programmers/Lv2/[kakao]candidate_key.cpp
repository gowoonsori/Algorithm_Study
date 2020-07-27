#include <string>
#include <vector>
#include <cmath>
#include <set>
#include <iostream>

using namespace std;

bool check_combination(vector<int> possible_key, int column){
    for(int i=0; i < possible_key.size(); i++)
        if( (possible_key[i] & column) == possible_key[i]) return false;
    return true;
}

int solution(vector<vector<string>> relation) {
    int max_column = relation[0].size();
    int max_row = relation.size();
    vector<int> possible_candidate_key;
    
    for(int i=1; i < pow(2,max_column); i++){
        set<string> tuples;
        for(int j=0; j < max_row; j++){
            string tuples_str = "";
            for(int k=0; k < max_column; k++)
                if(i & (1 << k)) tuples_str += relation[j][k] + " ";       
            tuples.insert(tuples_str);
        }
        if(tuples.size() == max_row && check_combination(possible_candidate_key,i)) 
            possible_candidate_key.push_back(i);
    }
    return possible_candidate_key.size();
}
int main(){
    vector<vector<string>> s = { {"ab","c"},{"a","bc"},{"a","x"},{"x","c"}};
    cout << solution(s) << endl;
}