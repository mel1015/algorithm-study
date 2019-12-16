//
// Created by sks10 on 2019-04-03.
//
#include <iostream>
#include <vector>
#include <deque>

using namespace std;

int N, time = 0, dir = 0;
vector<vector<char>> map;
vector<pair<int, char>> direction;
deque<pair<int, int>> snake;

// 우, 하, 좌, 상
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

void init() {
    cin >> N;
    map.resize(N + 1);
    for (int i = 0; i < N + 1; ++i) {
        map[i].resize(N + 1);
    }
    for (int i = 0; i < N + 1; ++i) {
        for (int j = 0; j < N + 1; ++j) {
            map[i][j] = '_';
        }
    }

    int K;
    cin >> K;
    for (int j = 0; j < K; ++j) {
        int x, y;
        cin >> x >> y;
        map[x][y] = 'A';
    }
    int L;
    cin >> L;
    for (int k = 0; k < L; ++k) {
        int x;
        char dir;
        cin >> x >> dir;
        direction.emplace_back(x, dir);
    }
}

void changeDirection(char direction) {
    // 방향 전환
    if (direction == 'D') {
        if (dir == 0) dir = 1;
        else if (dir == 1) dir = 2;
        else if (dir == 2) dir = 3;
        else if (dir == 3) dir = 0;
    } else {
        if (dir == 0) dir = 3;
        else if (dir == 1) dir = 0;
        else if (dir == 2) dir = 1;
        else if (dir == 3) dir = 2;
    }
}

void printMap() {
    for (int i = 1; i < N + 1; ++i) {
        for (int j = 1; j < N + 1; ++j) {
            cout << map[i][j];
        }
        cout << endl;
    }
}

int solution() {
    int x = 1, y = 1, backX, backY;
    for (int i = 0; i < direction.size();) {
        // 첫 위치 (1, 1)에 머리
        // 뱀의 위치를 덱에 넣어줌
        map[x][y] = 'H';
        snake.emplace_back(x, y);
        while (true) {
            // printMap();
            // 시간 증가
            time++;
            // 이전 좌표 backX, backY
            // 다음 좌표 x, y
            backX = x, backY = y;
            x += dx[dir], y += dy[dir];
            // 맵을 벗어나거나 자신의 몸통 'B'를 만나면 리턴
            if (x > N || x <= 0 || y > N || y <= 0 || map[x][y] == 'B') return time;
            if (map[x][y] == 'A') {
                // 사과가 놓인 위치로 이동
                // 이동 할 위치를 덱에 넣고 머리(H)로 표시
                // 이전 좌표는 몸통(B)로 바꿈
                snake.emplace_back(x, y);
                map[x][y] = 'H';
                map[backX][backY] = 'B';
            } else {
                // 사과가 놓인 위치가 아닐 때
                // 머리를 우선 이동 시키고
                snake.emplace_back(x, y);
                map[x][y] = 'H';
                // 뱀이 몸통이 있다면
                if (snake.size() > 1) {
                    // 머리가 있던 위치를 몸통으로 바꾸고
                    map[backX][backY] = 'B';
                    // 뱀의 꼬리 좌표를 가져옴
                    backX = snake.front().first;
                    backY = snake.front().second;
                }
                // 꼬리의 위치를 빈칸으로 변경
                map[backX][backY] = '_';
                // 꼬리를 빼냄
                snake.pop_front();
            }
            // 방향을 바꿀 시간이 되면 방향 전환
            if (time == direction[i].first) {
                changeDirection(direction[i++].second);
            }
        }
    }
}

int main() {
    init();
    solution();
    cout << time << endl;
    return 0;
}