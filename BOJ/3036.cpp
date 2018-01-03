//
// Created by sks10 on 2017-09-15.
//

#include <iostream>

using namespace std;

int gcd(int a, int b) {
    if (b <= 0)
        return a;
    return gcd(b, a % b);
}

int main() {

    int n, first, other;

    cin >> n;
    cin >> first;
    for (int i = 1; i < n; ++i) {
        int gcd_value = 0;
        cin >> other;
        gcd_value = gcd(first, other);
        cout << first / gcd_value << "/" << other / gcd_value << endl;
    }
    return 0;
}