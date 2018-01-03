//
// Created by sks10 on 2017-08-31.
//

#include <iostream>

using namespace std;

int count_zero = 0, count_one = 0;

int fibonacci(int n) {
    if (n == 0) {
        count_zero++;
        return 0;
    } else if (n == 1) {
        count_one++;
        return 1;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

int main() {
    int t, n;

    cin >> t;
    while (t--) {
        count_zero = 0, count_one = 0;
        cin >> n;
        fibonacci(n);
        cout << count_zero << " " << count_one << endl;
    }
    return 0;
}
