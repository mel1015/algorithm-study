//
// Created by sks10 on 2018-05-19.
//
#include <iostream>
#include <vector>

using namespace std;

vector<vector<int> > tree;
vector<vector<int> > nodePerLevel;
vector<bool> isRoot;
int inorderNum = 0;
int depth = 0;

void InorderNumbering(int node, int height) {
    // 왼쪽 자식노드가 없으면 리턴
    if (node == -1) return;

    // 트리의 레벨
    if (height > depth)
        depth = height;

    // 중위 순회 -> 왼쪽 자식노드로 내려가고 깊이 1증가
    InorderNumbering(tree[node][0], height + 1);

    // 중위 순회의 방문 순서에 따른 넘버링
    inorderNum++;
    cout << node << " -> " << inorderNum << endl;
    if (nodePerLevel[height][0] == 0) {
        // 해당 레벨에서의 가장 왼쪽노드 저장
        nodePerLevel[height][0] = inorderNum;
//        cout << "map[" << height << "][0] = " << inorderNum << endl;
    }
    // 해당 레벨에서의 가장 오른쪽 노드 저장
    nodePerLevel[height][1] = inorderNum;
//    cout << "map[" << height << "][1] = " << inorderNum << endl;

    InorderNumbering(tree[node][1], height + 1);
}

int main() {
    int n;
    int root, left, right, treeRoot = 0;

    cin >> n;

    // 벡터 사이즈 초기화
    tree.resize(n + 1);
    nodePerLevel.resize(n + 1);
    isRoot.resize(n + 1, true);

    // 2개의 값만 저장하므로 크기는 2
    for (int i = 1; i <= n; ++i) {
        nodePerLevel[i].resize(2);
    }

    // 입력
    for (int i = 1; i <= n; ++i) {
        cin >> root >> left >> right;
        tree[root].push_back(left);
        tree[root].push_back(right);

        // 루트 찾기
        // 부모노드가 없는 노드가 루트
        // 따라서 주어진 왼쪽, 오른쪽 자식노드는 false
        if (left != -1) isRoot[left] = false;
        if (right != -1) isRoot[right] = false;
    }

    // 루트 찾기
    for (int i = 1; i <= n; ++i) {
        if (isRoot[i]) {
            treeRoot = i;
            break;
        }
    }

    // 중위 순회 시작
    InorderNumbering(treeRoot, 1);

    // 너비가 가장 넓은 레벨과 그 레벨의 너비 찾기
    int level = 0, width = 0, temp = 0;
    for (int i = 1; i <= depth; ++i) {
        temp = nodePerLevel[i][1] - nodePerLevel[i][0] + 1;
        if (temp > width) {
            level = i;
            width = temp;
        }
    }

    cout << level << " " << width;
    return 0;
}
