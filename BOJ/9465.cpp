//
// Created by sks10 on 2017-08-16.
//

#include<iostream>

using namespace std;

int dp[2][100001];
int board[2][100001];

int main() {
    int i, j, n, T;
    cin >> T;

    while (T--) {
        cin >> n;
        for (j = 0; j < 2; j++)
            for (i = 0; i < n; i++)
                cin >> board[j][i];

        dp[0][0] = board[0][0];
        dp[1][0] = board[1][0];
        dp[0][1] = dp[1][0] + board[0][1];
        dp[1][1] = dp[0][0] + board[1][1];

        for (i = 2; i < n; i++) {
            dp[0][i] = max(dp[0][i - 2], dp[1][i - 2]);
            dp[0][i] = max(dp[1][i - 1], dp[0][i]);
            dp[0][i] += board[0][i];

            dp[1][i] = max(dp[0][i - 2], dp[1][i - 2]);
            dp[1][i] = max(dp[0][i - 1], dp[1][i]);
            dp[1][i] += board[1][i];
        }

        cout << max(dp[0][n - 1], dp[1][n - 1]) << endl;
    }

    return 0;
}
