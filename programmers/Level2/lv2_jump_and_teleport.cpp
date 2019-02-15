//
// Created by sks10 on 2019-02-14.
//
#include <iostream>

using namespace std;

int solution(int n) {
    int ans = 0;
    // 짝수는 순간 이동만으로
    // 만들 수 있으므로
    // n을 2로 나누면서
    // 홀수가 몇번 나오는지
    while (n) {
        if (n % 2) ans++;
        n /= 2;
    }
    return ans;
}

int main() {
    int n;
    cin >> n;
    cout << solution(n);
    return 0;
}