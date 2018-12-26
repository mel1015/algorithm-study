//
// Created by sks10 on 2018-12-26.
//
#include <iostream>
#include <cmath>

using namespace std;

int solution(int n) {
    int answer = 0;
    for (int i = 1; i <= n; ++i) {
        if (n % i == 0) answer += i;
    }
    return answer;
}

int main() {
    int n;
    cin >> n;
    cout << solution(n);
    return 0;
}