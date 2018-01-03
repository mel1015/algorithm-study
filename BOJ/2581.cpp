//
// Created by sks10 on 2017-08-23.
//

#include <iostream>

using namespace std;


bool prime_number(int num) {
    if (num == 1) {
        return false;
    }
    for (int i = 2; i * i <= num; ++i) {
        if (num % i == 0)
            return false;
    }
    return true;
}

int main() {
    int M, N, first = 0, sum = 0;
    bool check = true;

    cin >> M >> N;

    for (int i = M; i <= N; ++i) {
        if (prime_number(i)) {
            if (check) {
                first = i;
                check = false;
            }
            sum += i;
        }
    }
    if (sum == 0)
        cout << -1 << endl;
    else
        cout << sum << endl << first;

    return 0;
}
