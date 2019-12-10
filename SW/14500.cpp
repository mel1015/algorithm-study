//
// Created by sks10 on 2019-04-04.
//
#include <iostream>
#include <vector>

using namespace std;

int N, M, answer = 0;
vector<vector<int>> map;
vector<vector<bool>> visited;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

// ㅗ 모양을 제외한 모든 테트로미노는
// DFS의 방문 위치들로 만들 수 있음
void DFS(int x, int y, int count, int sum) {
    if (count == 4) {
        // 네 곳을 방문하면 최댓값 갱신 후 종료
        answer = max(answer, sum);
        return;
    }
    for (int i = 0; i < 4; ++i) {
        // 상하좌우
        int nextX = x + dx[i];
        int nextY = y + dy[i];
        // 범위, 방문 여부 체크
        if (nextX < N && nextX >= 0 && nextY < M && nextY >= 0 && !visited[nextX][nextY]) {
            // 방문 체크 후 다음 좌표로 DFS 실행
            visited[nextX][nextY] = true;
            DFS(nextX, nextY, count + 1, sum + map[nextX][nextY]);
            // 방문 초기화 => 다음 DFS 시작을 위해
            visited[nextX][nextY] = false;
        }
    }
}

// DFS로 체크 불가능한 모양
void notDFS() {
    // ㅗ 모양
    for (int i = 1; i < N; i++) {
        for (int j = 1; j < M - 1; j++) {
            int temp = map[i][j] + map[i - 1][j] + map[i][j - 1] + map[i][j + 1];
            answer = max(answer, temp);
        }
    }
    // ㅜ 모양
    for (int i = 0; i < N - 1; i++) {
        for (int j = 1; j < M - 1; j++) {
            int temp = map[i][j] + map[i + 1][j] + map[i][j - 1] + map[i][j + 1];
            answer = max(answer, temp);
        }
    }
    // ㅓ 모양
    for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < M; j++) {
            int temp = map[i][j] + map[i + 1][j] + map[i - 1][j] + map[i][j - 1];
            answer = max(answer, temp);
        }
    }
    // ㅏ 모양
    for (int i = 1; i < N - 1; i++) {
        for (int j = 0; j < M - 1; j++) {
            int temp = map[i][j] + map[i + 1][j] + map[i - 1][j] + map[i][j + 1];
            answer = max(answer, temp);
        }
    }
}

int main() {
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
        }
    }

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            // 브루트 포스
            // 모든 좌표마다 DFS를 실행하여
            // 최댓값 갱신
            visited[i][j] = true;
            DFS(i, j, 1, map[i][j]);
            visited[i][j] = false;
        }
    }
    notDFS();
    cout << answer;
    return 0;
}
