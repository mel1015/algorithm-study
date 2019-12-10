//
// Created by sks10 on 2019-04-01.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N;
int ans = 0;
vector<vector<int>> board;

void move(int dir) {
    queue<int> q;
    switch (dir) {
        case 0:
            // 상
            // 열마다 행을 증가시킴
            for (int col = 0; col < N; ++col) {
                for (int row = 0; row < N; ++row) {
                    // 0이 아닌 값이 있을 시
                    // 큐에 넣고 0으로 값을 바꿔
                    // 이동할 수 있는 자리로 만듬
                    if (board[row][col]) {
                        q.push(board[row][col]);
                        board[row][col] = 0;
                    }
                }

                int index = 0;
                while (!q.empty()) {
                    int block = q.front();
                    q.pop();
                    // 현재 블록이 이동할 방향일 때(가장 위)
                    // 0으로 바꿨던 값을 다시 2로 변경
                    if (!board[index][col]) board[index][col] = block;
                    else if (board[index][col] == block) {
                        // 이동할 위치에 같은 값의 블록이 있을 시
                        // 값을 더해주고 인덱스(행) 증가
                        board[index][col] *= 2;
                        index++;
                    } else {
                        // 블록 이동
                        board[++index][col] = block;
                    }
                }
            }
            break;

        case 1:
            // 하
            // 열마다 행을 감소
            for (int col = 0; col < N; ++col) {
                for (int row = N - 1; row >= 0; --row) {
                    if (board[row][col]) {
                        q.push(board[row][col]);
                        board[row][col] = 0;
                    }
                }
                int index = N - 1;
                while (!q.empty()) {
                    int block = q.front();
                    q.pop();
                    if (!board[index][col]) board[index][col] = block;
                    else if (board[index][col] == block) {
                        board[index][col] *= 2;
                        index--;
                    } else board[--index][col] = block;
                }
            }
            break;

        case 2:
            // 좌
            for (int row = 0; row < N; ++row) {
                for (int col = 0; col < N; ++col) {
                    if (board[row][col]) {
                        q.push(board[row][col]);
                        board[row][col] = 0;
                    }
                }
                int index = 0;
                while (!q.empty()) {
                    int block = q.front();
                    q.pop();
                    if (!board[row][index]) board[row][index] = block;
                    else if (board[row][index] == block) {
                        board[row][index] *= 2;
                        index++;
                    } else board[row][++index] = block;
                }
            }
            break;

        case 3:
            // 우
            for (int row = 0; row < N; ++row) {
                for (int col = N - 1; col >= 0; --col) {
                    if (board[row][col]) {
                        q.push(board[row][col]);
                        board[row][col] = 0;
                    }
                }
                int index = N - 1;
                while (!q.empty()) {
                    int block = q.front();
                    q.pop();
                    if (!board[row][index]) board[row][index] = block;
                    else if (board[row][index] == block) {
                        board[row][index] *= 2;
                        index--;
                    } else board[row][--index] = block;
                }
            }
            break;
        default:
            break;
    }
}

void solution(int count) {
    // 5번의 이동 후에 최댓값 저장
    if (count == 5) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                ans = max(ans, board[i][j]);
            }
        }
        return;
    }
    // 백업 배열
    vector<vector<int>> temp = board;
    for (int i = 0; i < 4; ++i) {
        // 모든 방향으로 탐색
        // 0 0 0 0 0 -> ... -> 0 0 0 0 3
        // 0 0 0 1 0 -> ... -> 0 0 0 1 3
        // 0 0 0 2 0 -> ... -> 0 0 0 2 3
        // ...
        // 3 3 3 3 3
        move(i);
        solution(count + 1);
        // 원래 상태로 백업
        board = temp;
    }
}

int main() {
    cin >> N;
    board.resize(N);
    for (int i = 0; i < N; ++i) {
        board[i].resize(N);
    }
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cin >> board[i][j];
        }
    }
    solution(0);
    cout << ans;
    return 0;
}