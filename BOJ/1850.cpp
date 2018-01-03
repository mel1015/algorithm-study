//
// Created by sks10 on 2017-09-15.
//

#include <iostream>

using namespace std;

unsigned long long int gcd(unsigned long long int a, unsigned long long int b) {
    if (b <= 0)
        return a;
    return gcd(b, a % b);
}

int main() {
    unsigned long long int a, b, gcd_value;
    cin >> a >> b;

    gcd_value = gcd(a, b);

    for (int i = 1; i <= gcd_value; ++i)
        cout << 1;

    return 0;
}
