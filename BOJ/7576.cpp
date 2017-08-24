//
// Created by sks10 on 2017-08-16.
//

#include <iostream>

using namespace std;

int arr[1005][1005];
int day = 0;

void check(int m, int n, int arr[1005][1005]) {
    int ripe = 0, tomato = 0, none = 0, total = m * n;

    for (int i = 1; i <= m; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (arr[i][j] == -1) {
                total--;
                none++;
            } else if (arr[i][j] == 0) {
                tomato++;
            } else if (arr[i][j] == 1) {
                ripe++;
                if (arr[i + 1][j] == 0) {
                    arr[i + 1][j] = 1;
                }
                if (arr[i - 1][j] == 0) {
                    arr[i - 1][j] = 1;
                }
                if (arr[i][j + 1] == 0) {
                    arr[i][j + 1] = 1;
                }
                if (arr[i][j - 1] == 0) {
                    arr[i][j - 1] = 1;
                }
            }
        }
    }
    if (ripe == total) {
        if (day == 0) {
            cout << 0 << endl;
            exit(0);
        } else {
            cout << day << endl;
            exit(0);
        }
    } else if (none + tomato == total) {
        cout << -1 << endl;
        exit(0);
    }
    day++;
    check(m, n, arr);
}

int main() {
    int m, n;
    cin >> m >> n;

    for (int i = 0; i < 1005; ++i)
        for (int j = 0; j < 1005; ++j)
            arr[i][j] = -1;

    for (int i = 1; i <= m; ++i)
        for (int j = 1; j <= n; ++j)
            cin >> arr[i][j];

    check(m, n, arr);

    return 0;
}