#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void Next_permutation(vector<vector<int>> &arr,int idx){
    int i=1,j=arr[idx].size()-1;
    while(arr[i] < arr[i-1]) {i++;}
    while(i <= j && arr[j] < arr[i-1]){j--;}
    swap(arr[idx][i-1],arr[idx][j]);

    j = arr[idx].size()-1;
    while(i<j){swap(arr[idx][i++],arr[idx][j--]);}
}

int main()
{
    int N,K;
    cin >> N >> K;
    vector<vector<int>> arr(K,vector<int>(N,0));

    for(int i=0; i <K;i++){
        for(int j=0; j < N; j++){
            cin >> arr[i][j];
        }
    }
    for(int i=0; i < K; i++){
        next_permutation(arr[i].begin(),arr[i].end());
    }
    for(int i=0; i < K; i++){
        for(int j=0; j < N ; j++){
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
    
    
}

