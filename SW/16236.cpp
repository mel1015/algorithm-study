//
// Created by sks10 on 2019-05-21.
//
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>

#define endl "\n"

using namespace std;

typedef pair<int, int> pairInt;

int N, sharkSize = 2, second = 0, ate = 0;
vector<vector<int>> map;
vector<vector<int>> visited;
vector<pair<pairInt, int>> canEat;
queue<pair<pairInt, int>> q;
pairInt sharkPos;

int dr[4] = {1, 0, 0, -1};
int dc[4] = {0, 1, -1, 0};

void clearVisit() {
    visited.clear();
    visited.resize(N);
    for (int i = 0; i < N; ++i) {
        visited[i].resize(N);
    }
}

bool cmp(pair<pairInt, int> a, pair<pairInt, int> b) {
    if (a.second <= b.second) {
        if (a.second == b.second) {
            if (a.first.first <= b.first.first) {
                if (a.first.first == b.first.first) {
                    if (a.first.second < b.first.second) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }
    return false;
}

void solution() {
    while (true) {
        // 초기화 작업
        canEat.clear();
        clearVisit();
        // 현재 상어의 위치를 방문 체크
        visited[sharkPos.first][sharkPos.second] = 1;
        q.push({sharkPos, 0});

        // BFS
        while (!q.empty()) {
            // 현재 위치와 올 때까지 걸린 시간
            int curRow = q.front().first.first;
            int curCol = q.front().first.second;
            int time = q.front().second;
            q.pop();
            // 4방향 탐색
            for (int i = 0; i < 4; ++i) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                // 범위 체크
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
                // 방문 여부 체크
                if (!visited[nextRow][nextCol]) {
                    if (!map[nextRow][nextCol] || map[nextRow][nextCol] == sharkSize) {
                        // 이동이 가능하면
                        // 이동한 지점 방문 체크
                        visited[nextRow][nextCol] = 1;
                        // 큐에 이동 위치와 시간 push
                        q.push({{nextRow, nextCol}, time + 1});
                    } else if (map[nextRow][nextCol] < sharkSize) {
                        // 물고기가 있고, 먹을 수 있다면
                        // 방문 체크
                        visited[nextRow][nextCol] = 1;
                        // 먹을 수 있는 물고기의 위치와 걸린 시간 저장
                        canEat.push_back({{nextRow, nextCol}, time + 1});
                    }
                }
            }
        }
        // 먹을 수 있는 물고기가 없으면 리턴
        if (canEat.empty()) return;
        // 주어진 조건에 맞게 먹을 수 있는 물고기를 순서대로 정리
        sort(canEat.begin(), canEat.end(), cmp);
        // 먹은 물고기의 위치 => 아기 상어의 새로운 위치
        int r = canEat[0].first.first;
        int c = canEat[0].first.second;
        // 빈공간으로 변경
        map[r][c] = 0;
        // 총 걸린 시간 추가, 먹은 물고기 수 증가
        second += canEat[0].second;
        ate++;
        if (ate == sharkSize) {
            // 먹은 물고기 수가 현재 상어의 크기와 같으면
            // 상어 크기 증가, 먹은 물고기 수 초기화
            sharkSize++;
            ate = 0;
        }
        // 상어 위치 갱신
        sharkPos = {r, c};
    }
}

void init() {
    cin >> N;
    map.resize(N);
    visited.resize(N);
    for (int i = 0; i < N; ++i) {
        map[i].resize(N);
        visited[i].resize(N);
        for (int j = 0; j < N; ++j) {
            cin >> map[i][j];
            if (map[i][j] == 9) {
                sharkPos = {i, j};
                map[i][j] = 0;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    init();
    solution();
    cout << second << endl;

    return 0;
}
