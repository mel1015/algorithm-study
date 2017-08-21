//
// Created by sks10 on 2017-08-21.
//

#include <iostream>

using namespace std;

int gcd(int a, int b) {
    if (b == 0)
        return a;
    else
        return gcd(b, a % b);
}

int main() {
    int cases, m, n, x, y;

    cin >> cases;

    while (cases--) {

        cin >> m >> n >> x >> y;

        int max = m / gcd(m, n);
        bool check = false;

        for (int i = 0; i < max; ++i) {
            if ((n * i + y - x) % m == 0) {
                cout << n * i + y << endl;
                check = true;
                break;
            }
        }
        if (!check) {
            cout << -1 << endl;
        }
    }
    return 0;
}