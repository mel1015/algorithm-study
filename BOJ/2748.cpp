//
// Created by sks10 on 2017-08-26.
//

#include <iostream>

using namespace std;

int main() {
    int n;
    long long int fib, pre = 0, next = 1;

    cin >> n;
    if (n == 0) {
        cout << 0 << endl;
    } else if (n == 1) {
        cout << 1 << endl;
    } else {
        for (int i = 2; i <= n; ++i) {
            fib = pre + next;
            pre = next;
            next = fib;
        }
        cout << fib << endl;
    }
    return 0;
}