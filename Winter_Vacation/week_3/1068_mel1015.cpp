//
// Created by sks10 on 2018-01-09.
//
#include <iostream>

using namespace std;

int n, node[50], leaf[50];

int dfs(int index) {
    bool has_child = false;
    for (int i = 0; i < n; ++i) {
        if (i == index)
            continue;
        if (node[i] == index) {
            // 자식노드가 존재하면 카운트를 증가시키고
            // 부모노드의 리프 개수에 자식노드의 리프 개수들을 더함
            has_child = true;
            leaf[index] += dfs(i);
        }
    }
    if (!has_child) {
        // 자식 노드가 존재하지 않으면
        // 자신의 자식 노드는 0, 부모에겐 1 리턴
        leaf[index] = 0;
        return 1;
    }
    return leaf[index];
}

int main() {

    int start = 0, del;

    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> node[i];
        if (node[i] == -1)
            start = i;
    }

    cin >> del;

    dfs(start);

    if (start == del){
        // 루트를 지울 경우
        cout << 0 << endl;
    } else if (leaf[start] - leaf[del] == 0) {
        // 루트 말고 나머지를 모두 지울 경우
        cout << 1 << endl;
    } else if (leaf[del] == 0 && node[del] == start) {
        // 리프이고 자신의 부모가 루트일 경우
        cout << leaf[start] - 1 << endl;
    } else if (leaf[del] == 0 && leaf[node[del]] > 1) {
        // 리프이고 부모의 자식이 1개보다 많을 경우
        cout << leaf[start] - 1 << endl;
    } else {
        cout << leaf[start] - leaf[del] << endl;
    }
    return 0;
}