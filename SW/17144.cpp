//
// Created by sks10 on 2019-05-21.
//
#include <iostream>
#include <vector>
#include <iomanip>

#define endl "\n"

using namespace std;

int R, C, T, answer = 0;
vector<vector<int>> map;
vector<vector<int>> tempMap;
vector<int> cleaner;

int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};

void init() {
    cin >> R >> C >> T;
    map.resize(R);
    tempMap.resize(R);
    for (int i = 0; i < R; ++i) {
        map[i].resize(C);
        tempMap[i].resize(C);
        for (int j = 0; j < C; ++j) {
            cin >> map[i][j];
            if (map[i][j] == -1) cleaner.push_back(i);
        }
    }
}

void spreadOut() {
    tempMap = map;
    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            if (tempMap[i][j] != 0) {
                int count = 0;
                for (int k = 0; k < 4; ++k) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (map[nr][nc] != -1) {
                        // 주변 미세먼지 확산에 영향 받기 전의 값으로
                        // 확산을 일으키고 더함
                        tempMap[nr][nc] += map[i][j] / 5;
                        count++;
                    }
                }
                tempMap[i][j] -= (map[i][j] / 5) * count;
            }
        }
    }
    map = tempMap;
}

void airCleaner() {
    // 위쪽 공기청정기
    // ↓ ←
    // → ↑
    // 공기청정기가 있는 열, 위 칸의 값이 아래로
    for (int i = cleaner[0] - 1; i > 0; --i) {
        map[i][0] = map[i - 1][0];
    }
    // 맨 윗 행, 우측 칸의 값이 좌측으로
    for (int i = 0; i < C - 1; ++i) {
        map[0][i] = map[0][i + 1];
    }
    // 맨 오른쪽 열, 아래 칸의 값이 위로
    for (int i = 1; i <= cleaner[0]; ++i) {
        map[i - 1][C - 1] = map[i][C - 1];
    }
    // 공기청정기가 있는 행, 왼쪽 칸의 값이 오른쪽으로
    for (int i = C - 1; i > 1; --i) {
        map[cleaner[0]][i] = map[cleaner[0]][i - 1];
    }
    // 공기청정기 바로 다음 칸에 0추가
    map[cleaner[0]][1] = 0;

    // 2. 아래 공기청정기
    // → ↓
    // ↑ ←
    // 공기청정기가 있는 열, 아래 칸의 값이 위로
    for (int i = cleaner[1] + 1; i < R - 1; i++) {
        map[i][0] = map[i + 1][0];
    }
    // 맨 아래 행, 우측 칸의 값이 좌측으로
    for (int i = 0; i < C - 1; i++) {
        map[R - 1][i] = map[R - 1][i + 1];
    }
    // 맨 우측 열, 위 칸의 값이 아래로
    for (int i = R - 1; i >= cleaner[1]; i--) {
        map[i][C - 1] = map[i - 1][C - 1];
    }
    // 공기청정기가 있는 행, 왼쪽 칸의 값이 우측으로
    for (int i = C - 1; i > 1; i--) {
        map[cleaner[1]][i] = map[cleaner[1]][i - 1];
    }
    // 공기청정기 바로 다음 칸에 0추가
    map[cleaner[1]][1] = 0;
}

void printMap() {
    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            cout << setw(3) << map[i][j];
        }
        cout << endl;
    }
    cout << endl;
}

void solution() {
    for (int i = 1; i <= T; ++i) {
        spreadOut();
//        printMap();
        airCleaner();
//        printMap();
    }
    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            answer += map[i][j];
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    init();
    solution();
    cout << answer + 2 << endl;

    return 0;
}