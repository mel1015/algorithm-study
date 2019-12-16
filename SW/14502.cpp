//
// Created by sks10 on 2019-04-05.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M, answer = 0;
vector<vector<int>> map;
vector<vector<int>> temp;

vector<vector<bool>> visited;
vector<pair<int, int>> virus;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};

void infection() {
    queue<pair<int, int>> q;
    for (int i = 0; i < virus.size(); ++i) {
        q.push(virus[i]);
    }
    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; ++i) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= N || nextX < 0 || nextY >= M || nextY < 0
                || temp[nextX][nextY] != 0)
                continue;
            temp[nextX][nextY] = 2;
            q.push({nextX, nextY});
        }
    }
}

int countSafe() {
    int count = 0;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            if (!temp[i][j]) count++;
        }
    }
    return count;
}

// 벽을 세울 좌표 (x, y), 세운 벽 개수 count
void DFS(int x, int y, int count) {
    map[x][y] = 1;
    visited[x][y] = true;
    if (count == 3) {
        temp = map;
        infection();
        answer = max(answer, countSafe());
        map[x][y] = 0;
        visited[x][y] = false;
        return;
    }

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            // 벽을 세운 위치이거나 빈 공간이 아니면 넘어감
            if (visited[i][j] || map[i][j] != 0) continue;
            DFS(i, j, count + 1);
        }
    }
    map[x][y] = 0;
    visited[x][y] = false;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    map.resize(N);
    visited.resize(N);
    for (int i = 0; i < N; ++i) {
        map[i].resize(M);
        visited[i].resize(M);
    }
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> map[i][j];
            if (map[i][j] == 2) virus.emplace_back(i, j);
        }
    }
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            if (!map[i][j]) DFS(i, j, 1);
        }
    }
    cout << answer;
    return 0;
}
