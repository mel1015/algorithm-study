//
// Created by sks10 on 2017-08-31.
//
// 이미 계산했던 값은 계산하지 말자
// 문제의 제약을 이해한다

#include <iostream>

using namespace std;

int main() {

    int n, **map, **dp;

    cin >> n;

    map = new int *[n + 1];
    dp = new int *[n + 1];

    for (int i = 0; i <= n; ++i) {
        map[i] = new int[3];
        dp[i] = new int[3];
    }

    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j < 3; ++j) {
            cin >> map[i][j];
        }
    }

    dp[0][0] = dp[0][1] = dp[0][2] = map[0][0] = map[0][1] = map[0][2] = 0;

    for (int k = 1; k <= n; ++k) {
        dp[k][0] = min(dp[k - 1][1], dp[k - 1][2]) + map[k][0];
        dp[k][1] = min(dp[k - 1][0], dp[k - 1][2]) + map[k][1];
        dp[k][2] = min(dp[k - 1][0], dp[k - 1][1]) + map[k][2];
    }

    cout << min(min(dp[n][0], dp[n][1]), dp[n][2]) << endl;

    delete[] map, dp;
    return 0;
}