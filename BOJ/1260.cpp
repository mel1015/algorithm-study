//
// Created by sks10 on 2017-08-24.
//

#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;

vector<int> adj[1001];
bool visit[1001];

void DFS(int v) {
    visit[v] = true;
    cout << v << " ";
    for (int i = 0; i < adj[v].size(); i++) {
        int vertex = adj[v][i];
        if (!visit[vertex]) {
            DFS(vertex);
        }
    }
}

void BFS(int v) {
    queue<int> que;
    visit[v] = true;
    que.push(v);
    while (!que.empty()) {
        int front = que.front();
        cout << front << " ";
        que.pop();
        for (int i = 0; i < adj[front].size(); i++) {
            int vertex = adj[front][i];
            if (!visit[vertex]) {
                que.push(vertex);
                visit[vertex] = true;
            }
        }
    }
}

int main() {
    int n, m, v, ver1, ver2;

    cin >> n >> m >> v;

    for (int i = 1; i <= m; ++i) {
        cin >> ver1 >> ver2;
        adj[ver1].push_back(ver2);
        adj[ver2].push_back(ver1);
    }

    for (int j = 1; j <= n; ++j) {
        sort(adj[j].begin(), adj[j].end());
    }

    DFS(v);
    cout << endl;
    memset(visit, 0, sizeof(visit));
    BFS(v);
    cout << endl;

    return 0;
}
