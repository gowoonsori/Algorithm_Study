#include <string>
#include <vector>


using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;

    if(arr.size()==1)answer.push_back(-1);
    else{
        int min=arr[0];
        int idx=0;
        for(int i=0;i<arr.size();i++){
            if(min>arr[i]){ 
                min=arr[i];
                idx=i;
             }
        }
        arr.erase(arr.begin()+idx);
        return arr;
    }
    return answer;
}