//
// Created by sks10 on 2017-08-26.
//

#include <iostream>

using namespace std;

int factorial(int n) {
    if (n > 1)
        return n * factorial(n - 1);
    else
        return 1;
}

int main() {
    int n, k;
    cin >> n >> k;

    cout << factorial(n) / (factorial(k) * factorial(n - k)) << endl;

    return 0;
}