//
// Created by sks10 on 2017-09-03.
//
// 1. 방금 1계단을 올라온 경우 -> 무조건 2계단
// 2. 방금 2계단을 올라온 경우 -> 1계단 또는 2계단
//                          -> max(1계단, 2계단)
#include <iostream>

using namespace std;

int main() {
    int n, *stairs, **dp;

    cin >> n;

    stairs = new int[n + 1];
    dp = new int *[n + 1];

    for (int i = 0; i <= n; ++i) {
        dp[i] = new int[3];
    }

    for (int i = 1; i <= n; ++i) {
        cin >> stairs[i];
    }

    stairs[0] = dp[0][0] = dp[0][1] = dp[0][2] = 0;
    dp[1][1] = dp[1][2] = stairs[1];

    for (int i = 2; i <= n; ++i) {
        dp[i][1] = dp[i - 1][2] + stairs[i];
        dp[i][2] = max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
    }

    cout << max(dp[n][1], dp[n][2]);

    return 0;
}