//
// Created by sks10 on 2017-08-29.
//
// 큰 수 처리 이용한 풀이

#include <iostream>

using namespace std;

int fact[100000] = {1};

int factorial(int n) {
    int mok, last = 1, count = 0;
    for (int f = 1; f <= n; ++f) {
        mok = 0;
        for (int i = 0; i < last; ++i) {
            fact[i] = fact[i] * f + mok;
            mok = fact[i] / 10;
            fact[i] %= 10;
        }
        for (; mok != 0; last++) {
            fact[last] = mok % 10;
            mok /= 10;
        }
    }
    for (int i = 0; i <= last - 1; ++i) {
        if (fact[i] == 0) {
            count++;
        } else if (fact[i] != 0) {
            break;
        }
    }
    return count;
}

int main() {
    int n;
    cin >> n;

    cout << factorial(n) << endl;

    return 0;
}