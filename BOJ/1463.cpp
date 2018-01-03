//
// Created by sks10 on 2017-09-04.
//

#include <iostream>

using namespace std;

int dp[1000001];

int main() {
    int n;
    cin >> n;
    for (int i = n; i > 0; --i) {
        if (dp[i - 1] == 0 || dp[i] + 1 < dp[i - 1]) {
            dp[i - 1] = dp[i] + 1;
        }
        if (i % 2 == 0) {
            if (dp[i / 2] > dp[i] + 1) {
                dp[i / 2] = dp[i] + 1;
            } else if (dp[i / 2] == 0) {
                dp[i / 2] = dp[i] + 1;
            }
        }
        if (i % 3 == 0) {
            if (dp[i / 3] > dp[i] + 1) {
            } else if (dp[i / 3] == 0) {
                dp[i / 3] = dp[i] + 1;
            }
        }
    }
    cout << dp[1];

    return 0;
}
