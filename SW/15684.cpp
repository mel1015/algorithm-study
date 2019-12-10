//
// Created by sks10 on 2019-04-09.
//
#include <iostream>
#include <vector>

using namespace std;

// N 열, H 행, M 놓인 가로선 개수
int N, M, H, answer = INT32_MAX;
int map[31][11];

bool ladder() {
    // 하나의 열에서 행을 증가시키면서
    // 사다리가 있으면 이동할 열로 변경
    for (int col = 1; col <= N; ++col) {
        int currentCol = col;
        for (int row = 1; row <= H; ++row) {
            if (map[row][currentCol]) currentCol++;
            else if (map[row][currentCol - 1]) currentCol--;
        }
        // 최종 도착한 열이 자기 번호가 아니면 false
        if (currentCol != col) return false;
    }
    return true;
}

void dfs(int count) {
    if (count >= 4) return;
    if (ladder()) {
        answer = min(answer, count);
        return;
    }
    if (count == 3) return;
    // 하나의 열에서 행을 증가시키면서
    // 사다리가 안놓인 곳에 사다리들을 놓으면서
    // 탐색을 진행함
    for (int col = 1; col < N; ++col) {
        for (int row = 1; row <= H; ++row) {
            // 사다리가 연속하거나 접하면 안되므로
            // 사다리가 놓인 열은 패스
            if (map[row][col]) continue;
            if (map[row][col - 1] || map[row][col + 1])continue;
            // 사다리가 안놓인 위치에 사다리 놓고
            // 새로운 탐색을 진행
            // 다음 탐색을 위해 초기화
            map[row][col] = 1;
            dfs(count + 1);
            map[row][col] = 0;

            // 모든 행의 검사를 위해
            while (1) {
                if (row >= H) break;
                if (map[row + 1][col + 1] || map[row + 1][col - 1]) break;
                row++;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    // 열 N, 가로선의 개수 M, 행 H
    cin >> N >> M >> H;
    for (int i = 0; i < M; ++i) {
        int x, y;
        cin >> x >> y;
        // 사다리를 배열로 표시
        map[x][y] = 1;
    }
    dfs(0);
    if (answer > 3) answer = -1;
    cout << answer;
    return 0;
}
