#include <string>
#include <vector>
#include <iostream>

using namespace std;

void rotate_key(vector<vector<int>> &key){
    vector<vector<int>> temp(key.size(), vector<int>(key.size(),0));
    
    for(int i=0; i < key.size(); i++){
        for( int j=0; j < key.size(); j++){
            temp[j][key.size() -1-i] = key[i][j];
        }
    }
    key = temp;
}

bool check(vector<vector<int>> board, vector<vector<int>> key,  int start_idx,int lock_size, int key_startX, int key_startY){
    for(int i = 0; i < key.size(); i++ ){
        for(int j =  0;j < key.size(); j++){
            board[i + key_startY][j + key_startX] += key[i][j];
        }
    }
    for(int i = start_idx; i < start_idx + lock_size; i++ ){
        for(int j = start_idx; j < start_idx + lock_size; j++){
            if(board[i][j] != 1) return false;
        }
    }
    return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    bool answer = false;
    vector<vector<int>> board(lock.size() + (2 * (key.size())) ,vector<int>(lock.size() + (2 * (key.size())), 0)); 
    int start_idx= key.size() - 1, lock_size = lock.size();
    
    for(int i=0; i < lock.size() ; i++){
        for(int j= 0; j < lock.size(); j++){
            board[i + start_idx ][j + start_idx] = lock[i][j];
        }
    }
    
    for(int y = 0; y <= board.size() - key.size(); y++){
        for(int x = 0; x <= board.size() - key.size() ; x++ ){
            for(int i=0; i < 4; i++){
                rotate_key(key);
                if(check(board,key,start_idx,lock_size, x,y)) answer = true;
            }
        }
    }
    return answer;
}