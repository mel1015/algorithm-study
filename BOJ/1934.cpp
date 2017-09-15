//
// Created by sks10 on 2017-09-13.
//

#include <iostream>

using namespace std;

int lcm(int a, int b) {
    int lcm = 1;
    for (int i = 1; i <= max(a, b); i++) {
        if (a % i == 0 && b % i == 0) {
            lcm = (a / i) * (b / i) * i;
        }
    }
    return lcm;
}

int main() {

    int t, a, b;

    cin >> t;

    while (t--) {
        cin >> a >> b;
        cout << lcm(a, b) << endl;
    }
    return 0;
}