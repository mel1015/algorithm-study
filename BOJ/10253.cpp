//
// Created by sks10 on 2017-10-07.
//

#include <iostream>

using namespace std;

int gcd(int a, int b);

void henry(int a, int b);

int main() {
    int a, b, cases;

    cin >> cases;

    while (cases--) {
        cin >> a >> b;
        henry(a, b);
    }
    return 0;
}

int gcd(int a, int b) {
    return b ? gcd(b, a % b) : a;
}

void henry(int a, int b) {
    int x = a, y = b;
    int cnt;

    while (x != 1) {
        cnt = (y / x) + 1;
        x = x * cnt - y;
        y = y * cnt;
        int gcd_num = gcd(x, y);
        x /= gcd_num;
        y /= gcd_num;
    }
    cout << y << endl;
}