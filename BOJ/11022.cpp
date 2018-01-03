//
// Created by sks10 on 2017-08-15.
//

#include <iostream>

using namespace std;

int main() {
    int n, a, b, i = 1;

    for (cin >> n; n; n--) {
        cin >> a >> b;
        cout << "Case #" << i++ << ": "
             << a << " + " << b
             << " = " << a + b << endl;
    }
    return 0;
}