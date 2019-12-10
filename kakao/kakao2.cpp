//
// Created by sks10 on 2018-08-04.
//
#include <iostream>
#include <cmath>

using namespace std;

int favorite[501];

double solve(int k, int start) {
    double sum = 0;
    for (int i = 0; i < k; ++i) {
        sum += favorite[start + i];
    }
    double avg = sum / k;
    sum = 0;
    for (int j = 0; j < k; ++j) {
        sum += pow(favorite[start + j] - avg, 2);
    }
    double variance = sum / k;
    double std = sqrt(variance);
    return std;
}

int main() {
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < n; ++i) {
        cin >> favorite[i];
    }
    double result, ans = INT32_MAX;
    for (int i = k; i <= n; ++i) {
        for (int j = 0; j <= n - i; ++j) {
            result = solve(i, j);
            ans = min(ans, result);
        }
    }
    cout.precision(11);
    cout << ans;
    return 0;
}
