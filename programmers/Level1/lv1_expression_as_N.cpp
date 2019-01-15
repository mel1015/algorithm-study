//
// Created by sks10 on 2018-11-27.
//
// 다른 사람 풀이 분석
#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int N;
// 계산 결과를 저장할 set
unordered_set<int> dp[10];

unordered_set<int> solve(int n) {
    // 메모이제이션 된 값 불러옴
    if (!dp[n].empty()) return dp[n];
    int num = 0;
    // n개의 N으로 만들 수 있는 숫자 (5, 55, 555, ...)
    for (int i = 0; i < n; i++) num = 10 * num + N;
    // 연산 결과를 저장할 set
    unordered_set<int> cache;
    cache.insert(num);
    // N을 n번 사용하므로 i는 1부터 n까지
    for (int i = 1; i < n; i++) {
        // j = (1 <= n - i < 7)
        // i + j = n 이므로 N이 n번 사용되는 dp끼리 계산
        int j = n - i;
        // 메모이제이션
        auto s1 = solve(i);
        auto s2 = solve(j);
        for (int n1 : s1) {
            for (int n2 : s2) {
                // 사칙연산 계산
                cache.insert(n1 + n2);
                cache.insert(n1 - n2);
                cache.insert(n1 * n2);
                if (n2 != 0) cache.insert(n1 / n2);
            }
        }
    }
    // 계산된 결과를 dp[n]에 저장
    return dp[n] = cache;
}

int solution(int _N, int number) {
    N = _N;
    // 8번까지 계산
    for (int i = 1; i <= 8; i++) {
        // i개의 N이 사용됨
        solve(i);
        // number가 만들어 졌다면 사용된 N의 개수 리턴
        if (dp[i].find(number) != dp[i].end()) return i;
    }
    return -1;
}

int main() {
    int _N, number;
    cin >> _N >> number;
    cout << solution(_N, number) << endl;
    return 0;
}