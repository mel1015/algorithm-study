//
// Created by sks10 on 2019-05-08.
//
#include <iostream>
#include <queue>
#include <cstring>

#define endl "\n"

using namespace std;

int N, L, R, answer = 0;
int map[51][51];
bool visited[51][51];
int dr[4] = {1, 0, -1, 0};
int dc[4] = {0, 1, 0, -1};

bool canCombination(int r, int c, int nr, int nc) {
    int diff = abs(map[r][c] - map[nr][nc]);
    return diff >= L && diff <= R;
}

void bfs(int r, int c) {
    // 연합을 이루기 위한 큐와 인구수 변동을 위한 큐
    queue<pair<int, int>> bfsQ, unionQ;
    bfsQ.push({r, c});
    unionQ.push({r, c});
    visited[r][c] = true;

    int sum = 0, count = 0;
    while (!bfsQ.empty()) {
        int curRow = bfsQ.front().first;
        int curCol = bfsQ.front().second;
        bfsQ.pop();

        sum += map[curRow][curCol];
        count++;
        for (int i = 0; i < 4; ++i) {
            int nextRow = curRow + dr[i];
            int nextCol = curCol + dc[i];
            if (nextRow >= N || nextRow < 0 || nextCol >= N || nextCol < 0
                || visited[nextRow][nextCol]) continue;
            if (canCombination(curRow, curCol, nextRow, nextCol)) {
                visited[nextRow][nextCol] = true;
                bfsQ.push({nextRow, nextCol});
                unionQ.push({nextRow, nextCol});
            }
        }
    }
    int average = sum / count;
    while (!unionQ.empty()) {
        int row = unionQ.front().first;
        int col = unionQ.front().second;
        unionQ.pop();
        map[row][col] = average;
    }
}

void printMap() {
    cout << answer << "day " << L << " " << R << endl;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cout << map[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
}

void solution() {
    // 인구 이동을 진행할 조건
    bool flag = true;
    while (flag) {
        flag = false;
//        printMap();
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                for (int k = 0; k < 4; ++k) {
                    int nextRow = r + dr[k];
                    int nextCol = c + dc[k];
                    // 범위 체크
                    if (nextRow >= N || nextRow < 0 || nextCol >= N || nextCol < 0) continue;
                    // 연합이 가능하고, 방문하지 않았다면 진행
                    if (canCombination(r, c, nextRow, nextCol) && !visited[r][c]) {
                        bfs(r, c);
                        flag = true;
                    }
                }
            }
        }
        if (flag) answer++;
        // 다음 날의 인구이동 진행을 위해 방문 여부 초기화
        memset(visited, false, sizeof(visited));
    }
    cout << answer << endl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);

    cin >> N >> L >> R;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cin >> map[i][j];
        }
    }
    solution();
    return 0;
}
