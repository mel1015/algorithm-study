//
// Created by sks10 on 2018-01-27.
//
#include <iostream>
#include <queue>

using namespace std;

queue<int> que;
int graph[101][101];
bool visited[101];
int count = 0;

// 너비 우선 탐색
int Bfs(int size) {
    que.push(1);
    visited[1] = true;

    while (!que.empty()) {
        int current = que.front();
        que.pop();

        for (int i = 1; i <= size; ++i) {
            if (graph[current][i] && !visited[i]) {
                visited[i] = true;
                count++;
                que.push(i);
            }
        }
    }
    return count;
}

int main() {

    int n, m;
    cin >> n >> m;

    int x, y;
    while (m--) {
        cin >> x >> y;
        // 1 2 와 2 1 은 동일함
        graph[x][y] = 1;
        graph[y][x] = 1;
    }
    cout << Bfs(n);

    return 0;
}