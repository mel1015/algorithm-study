//
// Created by sks10 on 2018-02-08.
//
#include <iostream>
#include <queue>

using namespace std;

queue<int> que;
int graph[101][101];
bool visited[101][101];

// 너비 우선 탐색
void Bfs(int n) {

    for (int i = 1; i <= n; ++i) {
        que.push(i);

        while (!que.empty()) {
            int current = que.front();
            que.pop();

            for (int j = 1; j <= n; ++j) {
                if (graph[current][j] && !visited[i][j]) {
                    visited[i][j] = true;
                    que.push(j);
                }
            }
        }
    }
}

int main() {

    int n;
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            cin >> graph[i][j];
        }
    }

    Bfs(n);

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            cout << visited[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}