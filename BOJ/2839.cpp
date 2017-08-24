//
// Created by sks10 on 2017-08-17.
//

#include <iostream>

using namespace std;

int main() {
    int a, b, min = 5000, num;
    cin >> a;

    for (int i = 0; i <= a / 5; ++i) {
        b = a - (5 * i);
        if (b % 3 == 0) {
            num = i + (b / 3);
            if (num < min)
                min = num;
        }
    }

    if (min == 5000)
        cout << -1 << endl;
    else
        cout << min << endl;

    return 0;
}