//
// Created by sks10 on 2019-03-29.
//
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

typedef pair<int, int> pairInt;

//세로 = y = N, 가로 = x = M
int N, M;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, -1, 0, 1};

// 방문 여부
bool visit[13][13][13][13] = {false,};

vector<vector<char>> board;
queue<pair<pairInt, pairInt>> q;
pairInt red, blue;

int BFS() {
    // queue에 push
    q.push({red, blue});
    // 방문 표시
    visit[red.first][red.second][blue.first][blue.second] = true;

    int ans = 0;

    while (!q.empty()) {
        int qSize = q.size();
        while (qSize--) {
            // 현재 빨간 구슬 위치
            int curRedY = q.front().first.first;
            int curRedX = q.front().first.second;
            // 현재 파란 구슬 위치
            int curBlueY = q.front().second.first;
            int curBlueX = q.front().second.second;
            q.pop();

            // 빨간 구슬이 구멍에 들어가면 리턴
            // 두 구슬이 같이 들어가면 안됨
            if (board[curRedY][curRedX] == 'O'
                && board[curRedY][curRedX] != board[curBlueY][curBlueX]) {
                return ans;
            }

            // 상하좌우 4번
            for (int i = 0; i < 4; i++) {
                // 갱신 될 구슬 좌표
                int moveRedY = curRedY, moveRedX = curRedX;
                int moveBlueY = curBlueY, moveBlueX = curBlueX;

                // 이동할 수 있는 좌표로 이동
                // 장애물과 구멍이 아닌 곳
                while (board[moveRedY + dy[i]][moveRedX + dx[i]] != '#'
                       && board[moveRedY][moveRedX] != 'O') {
                    // 빨간 구슬 이동
                    moveRedY += dy[i];
                    moveRedX += dx[i];
                }
                while (board[moveBlueY + dy[i]][moveBlueX + dx[i]] != '#'
                       && board[moveBlueY][moveBlueX] != 'O') {
                    // 파란 구슬 이동
                    moveBlueY += dy[i];
                    moveBlueX += dx[i];
                }

                // 빨간 구슬과 파란 구슬의 위치가 같을 때
                if (moveRedY == moveBlueY && moveRedX == moveBlueX) {
                    if (board[moveRedY][moveRedX] == 'O') continue;

                    // 빨간 구슬의 이동량이 파란 구슬의 이동량보다 작다면
                    // 빨간 구슬이 우선권을 가짐
                    if (abs(moveRedY - curRedY) + abs(moveRedX - curRedX) <
                        abs(moveBlueY - curBlueY) + abs(moveBlueX - curBlueX)) {
                        moveBlueY -= dy[i];
                        moveBlueX -= dx[i];
                    } else {
                        // 파란 구슬이 우선권을 가질 때
                        moveRedY -= dy[i];
                        moveRedX -= dx[i];
                    }
                }
                // 방문한 좌표에 다시 갔을 때
                if (visit[moveRedY][moveRedX][moveBlueY][moveBlueX]) continue;
                // 방문 표시
                visit[moveRedY][moveRedX][moveBlueY][moveBlueX] = true;

                q.push({{moveRedY,  moveRedX},
                        {moveBlueY, moveBlueX}});
            }
        }

        // 10번 이상이면 -1 리턴
        if (ans >= 10) return -1;
        ++ans;
    }
    // 탈출 실패
    return -1;
}

int main() {
    cin >> N >> M;
    board.resize(N + 1);
    for (int i = 0; i < N; ++i) {
        board[i].resize(M + 1);
    }
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> board[i][j];
            if (board[i][j] == 'R') red = make_pair(i, j);
            if (board[i][j] == 'B') blue = make_pair(i, j);
        }
    }
    cout << BFS();
    return 0;
}
