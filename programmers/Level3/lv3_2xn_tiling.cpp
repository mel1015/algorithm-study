//
// Created by sks10 on 2018-09-09.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int dp[60001];

    // 2 X 1 => 1
    // 2 X 2 => 2
    // 2 X 3 => 1 + 2 = 3가지
    // 2 X 4 => 2 + 3 = 5가지
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
    }
    return dp[n];
}

int main() {
    int n;
    cin >> n;
    cout << solution(n);
    return 0;
}
