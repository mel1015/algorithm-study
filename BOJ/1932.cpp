//
// Created by sks10 on 2017-09-03.
//

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n, **map, **dp;

    cin >> n;

    map = new int *[n];
    dp = new int *[n];

    for (int i = 1; i <= n; ++i) {
        map[i - 1] = new int[n];
        dp[i - 1] = new int[n];
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i + 1; ++j) {
            cin >> map[i][j];
        }
    }

    dp[0][0] = map[0][0];

    for (int i = 1; i < n; ++i) {
        for (int j = 0; j < i + 1; ++j) {
            if (j == 0) {
                dp[i][j] = dp[i - 1][j] + map[i][j];
            } else if (j == i) {
                dp[i][j] = dp[i - 1][j - 1] + map[i][j];
            } else {
                dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j];
            }
        }
    }

    cout << *max_element(dp[n - 1], dp[n - 1] + n) << endl;

    delete[] map, dp;
    return 0;
}