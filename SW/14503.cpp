//
// Created by sks10 on 2019-04-05.
//
#include <iostream>
#include <vector>

using namespace std;

int N, M, X, Y, D, answer = 0;
int room[51][51];

// D => 0 북, 1 동, 2 남, 3 서
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
// 후진
int back_dx[4] = {1, 0, -1, 0};
int back_dy[4] = {0, -1, 0, 1};

void DFS(int x, int y, int dir) {
    // 청소하는 위치가 벽이면 DFS 종료
    // => 후진한 위치가 벽일 때
    if (room[x][y] == 1) return;
    // 청소 가능하면 청소하고
    // 값을 2로 바꿔서 청소한 위치 표시
    if (room[x][y] == 0) {
        room[x][y] = 2;
        answer++;
    }
    // 네 방향 탐색
    for (int i = 0; i < 4; ++i) {
        // 0 북, 1 동, 2 남, 3 서
        // 각 방향 값에서 -1 값이 다음 방향
        int nextDirection = dir - 1 < 0 ? 3 : dir - 1;
        // 이동할 위치
        int nextX = x + dx[nextDirection];
        int nextY = y + dy[nextDirection];
        // 범위 체크
        if (nextX > N || nextX < 0 || nextY > M || nextY < 0) continue;
        // 이동할 위치가 청소 가능하면
        // 이동할 위치에서 다시 탐색 실행
        if (room[nextX][nextY] == 0) {
            DFS(nextX, nextY, nextDirection);
            return;
        } else {
            // 청소가 불가능하면 방향을 바꿔
            // 다른 위치 탐색
            dir = nextDirection;
        }
    }
    // 네 방향 탐색이 끝났을 때 후진
    int nx = x + back_dx[dir], ny = y + back_dy[dir];
    DFS(nx, ny, dir);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    cin >> X >> Y >> D;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> room[i][j];
        }
    }
    DFS(X, Y, D);
    cout << answer;
    return 0;
}
