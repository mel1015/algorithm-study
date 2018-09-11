//
// Created by sks10 on 2018-09-10.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> money) {
    int answer = 0;
    vector<long> dp(n + 1);

    // 가장 작은 수로 만들 수 있는 숫자 초기화
    for (int i = 0; i <= n; ++i) {
        dp[i] = (i % money[0] == 0) ? 1 : 0;
    }

    // dp[j]에 j를 만들 수 있는 경우의 수 더해나감
    for (int i = 1; i < money.size(); ++i) {
        for (int j = money[i]; j <= n; ++j) {
            dp[j] += dp[j - money[i]];
        }
    }
    answer = (int) (dp[n] % 1000000007);
    return answer;
}

int main() {
    int n;
    vector<int> money = {1, 2, 5};
    vector<int> money2 = {2, 3, 5};
    cin >> n;
    cout << solution(n, money2);
    return 0;
}
