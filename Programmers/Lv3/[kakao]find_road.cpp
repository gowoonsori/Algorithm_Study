#include <bits/stdc++.h>

using namespace std;

struct Node {
    int key = -1;
    int x;
    Node* left = nullptr;
    Node* right = nullptr;
};

class BST {
   private:
    Node* root;

   public:
    BST() { root = nullptr; };
    void add(int key, int x) {
        Node* node = new Node;
        node->key = key;
        node->x = x;
        if (root == nullptr) {
            root = node;
            return;
        }
        Node* p = root;
        while (1) {
            if (p->x < x) {
                if (p->right == nullptr) {
                    p->right = node;
                    return;
                }
                p = p->right;
            } else {
                if (p->left == nullptr) {
                    p->left = node;
                    return;
                }
                p = p->left;
            }
        }
    };
    void preorder(Node* p, vector<vector<int>>& answer) {
        if (p == nullptr) return;
        answer[0].push_back(p->key);
        preorder(p->left, answer);
        preorder(p->right, answer);
    };
    void postorder(Node* p, vector<vector<int>>& answer) {
        if (p == nullptr) return;
        postorder(p->left, answer);
        postorder(p->right, answer);
        answer[1].push_back(p->key);
    };
    Node* getRoot() { return root; }
};

vector<vector<int>> solution(vector<vector<int>> nodeinfo);

int main() {
    vector<vector<int>> input = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
    solution(input);
    return 0;
}

bool compare(pair<pair<int, int>, int> a, pair<pair<int, int>, int> b) { return a.first.second > b.first.second; }

vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    vector<vector<int>> answer(2);
    vector<pair<pair<int, int>, int>> nodeInfoCpy;
    for (int i = 0; i < nodeinfo.size(); i++) {
        nodeInfoCpy.push_back({{nodeinfo[i][0], nodeinfo[i][1]}, i + 1});
    }

    sort(nodeInfoCpy.begin(), nodeInfoCpy.end(), compare);
    BST bst = BST();

    for (auto node : nodeInfoCpy) {
        bst.add(node.second, node.first.first);
    }
    bst.preorder(bst.getRoot(), answer);
    bst.postorder(bst.getRoot(), answer);

    return answer;
}