//
// Created by sks10 on 2018-05-08.
//
#include <iostream>

using namespace std;

char map[21][21];
bool visited[20];
// 상하좌우 이동
int xp[4] = {1, -1, 0, 0};
int yp[4] = {0, 0, 1, -1};
int r, c, res;

void dfs(int x, int y, int count) {
    // visited 배열의 0번 인덱스부터 A,B,C,D,...
    int alphabet = map[x][y] - 65;
    visited[alphabet] = true;

    // 이전의 결과값보다 현재값이 크면 갱신
    if (res < count) res = count;

    for (int i = 0; i < 4; ++i) {
        // 다음 좌표
        int nx = x + xp[i], ny = y + yp[i];
        // 범위 체크
        if (nx > 0 && ny > 0 && nx <= r && ny <= c) {
            // 다음 좌표의 알파벳
            int na = map[nx][ny] - 65;
            // 다음 알파벳의 방문 여부 체크
            if (!visited[na]) {
                dfs(nx, ny, count + 1);
            }
        }
    }
    // 되돌아올 경우가 있으므로
    visited[alphabet] = false;
}

int main() {
    cin >> r >> c;

    for (int i = 1; i <= r; ++i) {
        for (int j = 1; j <= c; ++j) {
            cin >> map[i][j];
        }
    }
    dfs(1, 1, 1);
    cout << res;

    return 0;
}
