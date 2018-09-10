//
// Created by sks10 on 2018-09-07.
//
#include <iostream>
#include <vector>

using namespace std;

// 세 수 중 가장 작은 것 리턴
int minThree(int a, int b, int c) {
    return (a > b) ? ((b > c) ? c : b) : ((a > c) ? c : a);
}

int solution(vector<vector<int>> board) {
    int answer = 0;
    int row = board.size(), col = board[0].size();
    bool notZero = false;

    for (int i = 0; i < row; ++i) {
        for (int j = 0; j < col; ++j) {
            // 영행렬이 아니면 크기가 1 이어야 하므로
            if (board[i][j] != 0) notZero = true;
            // DP -> 현 위치 값에 좌상, 좌, 상 중 가장 작은 숫자를 더함
            // 그 결과 가장 큰 숫자가 정사각형의 변의 길이
            if (board[i][j] != 0 && i != 0 && j != 0) {
                board[i][j] += minThree(board[i - 1][j - 1], board[i - 1][j], board[i][j - 1]);
                if (board[i][j] > answer) {
                    answer = board[i][j];
                }
            }
        }
    }
    // DP 계산에서 첫 행과 첫 열을 스킵해서 영행렬로 판단할 때가 있음
    // ex) [0, 0, 0, 0], [1, 0, 0, 0]
    if (notZero && !answer) answer = 1;
    return answer * answer;
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> board;
    board.resize(n);
    for (int i = 0; i <= n; ++i) {
        board[i].resize(m);
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> board[i][j];
        }
    }
    cout << solution(board);
    return 0;
}
