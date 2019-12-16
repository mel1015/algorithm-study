//
// Created by sks10 on 2019-04-03.
//
#include <iostream>
#include <vector>

using namespace std;

int N, M, diceX, diceY, K;
vector<vector<int>> map;
vector<int> command;
// 주사위 => 위,뒤,앞,밑,우,좌
int dice[6] = {0, 0, 0, 0, 0, 0};
// 동서북남
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};

void diceRoll(int command) {
    // 명령에 따라 주사위를 굴림
    int temp[4];
    switch (command) {
        case 1:
            // 0 위, 4 우, 3 밑, 5 좌
            temp[0] = dice[0];
            temp[1] = dice[4];
            temp[2] = dice[3];
            temp[3] = dice[5];

            dice[0] = temp[3];
            dice[4] = temp[0];
            dice[3] = temp[1];
            dice[5] = temp[2];
            break;
        case 2:
            // 0 위, 4 우, 3 밑, 5 좌
            temp[0] = dice[0];
            temp[1] = dice[4];
            temp[2] = dice[3];
            temp[3] = dice[5];

            dice[0] = temp[1];
            dice[4] = temp[2];
            dice[3] = temp[3];
            dice[5] = temp[0];
            break;
        case 3:
            // 0 위, 1 뒤, 2 앞, 3 밑
            temp[0] = dice[0];
            temp[1] = dice[1];
            temp[2] = dice[2];
            temp[3] = dice[3];

            dice[0] = temp[2];
            dice[1] = temp[0];
            dice[2] = temp[3];
            dice[3] = temp[1];
            break;
        case 4:
            // 0 위, 1 뒤, 2 앞, 3 밑
            temp[0] = dice[0];
            temp[1] = dice[1];
            temp[2] = dice[2];
            temp[3] = dice[3];

            dice[0] = temp[1];
            dice[1] = temp[3];
            dice[2] = temp[0];
            dice[3] = temp[2];
            break;
        default:
            break;
    }
}

void solution() {
    // 명령 모두 실행
    for (int i = 0; i < command.size(); ++i) {
        // 주사위의 다음 좌표
        int nextX = diceX + dx[command[i] - 1];
        int nextY = diceY + dy[command[i] - 1];
        // 범위 벗어나면 실행 X
        if (nextX >= N || nextX < 0 || nextY >= M || nextY < 0) continue;
        diceX = nextX, diceY = nextY;
        // 주사위 굴리기
        diceRoll(command[i]);
        if (!map[diceX][diceY]) {
            map[diceX][diceY] = dice[3];
            cout << dice[0] << endl;
        } else {
            dice[3] = map[diceX][diceY];
            map[diceX][diceY] = 0;
            cout << dice[0] << endl;
        }
    }
}


int main() {
    cin >> N >> M >> diceX >> diceY >> K;
    map.resize(N);
    for (int i = 0; i < N; ++i) {
        map[i].resize(M);
    }
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> map[i][j];
        }
    }
    command.resize(K);
    for (int i = 0; i < K; ++i) {
        cin >> command[i];
    }
    solution();
    return 0;
}
