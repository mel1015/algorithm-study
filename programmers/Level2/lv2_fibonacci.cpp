//
// Created by sks10 on 2018-09-09.
//
#include <iostream>
#include <vector>

using namespace std;

int solution(int n) {
    vector<int> fibo = {0, 1};

    for (int i = 2; i <= n; ++i) {
        int n = (fibo[i - 2] + fibo[i - 1]) % 1234567;
        fibo.push_back(n);
    }
    return fibo[n];
}

int main() {
    int n;
    for (int i = 0; i < 10; ++i) {
        cin >> n;
        cout << solution(n);
    }

    return 0;
}
