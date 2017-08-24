//
// Created by sks10 on 2017-08-23.
//

#include <iostream>

using namespace std;

bool arr[10001];

void prime_number(bool *arr, int M, int N) {
    int i, j;
    for (i = M; i <= N; ++i) {
        int count = 0;
        j = 1;
        for (j; j <= i; ++j) {
            if (i % j == 0) {
                count++;
            }
        }
        if (count == 2) {
            arr[i] = true;
        }
    }
}

int main() {
    int M, N, first;
    long long int sum = 0;
    bool check = true;
    cin >> M >> N;

    prime_number(arr, M, N);

    for (int i = M; i <= N; ++i) {
        if (arr[i]) {
            sum += i;
            if (check) {
                first = i;
            }
            check = false;
        }
    }
    if (check) {
        cout << -1 << endl;
    } else {
        cout << sum << endl << first;
    }

    return 0;
}
