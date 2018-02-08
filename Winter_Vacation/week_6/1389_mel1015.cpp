//
// Created by sks10 on 2018-02-08.
//
#include <iostream>

using namespace std;

#define INF 100001
int arr[101][101];
int bacon[101];

void init(int n) {
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            arr[i][j] = i == j ? 0 : INF;
        }
    }
}

void floyd(int n) {
    for (int k = 1; k <= n; ++k) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == j)continue;
                if (arr[i][j] > arr[i][k] + arr[k][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    init(n);

    int from, to;
    while (m--) {
        cin >> from >> to;
        arr[from][to] = arr[to][from] = 1;
    }

    floyd(n);

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (arr[i][j] == INF) {
                arr[i][j] = 0;
            }
            bacon[i] += arr[i][j];
        }
    }

    int min = 0, temp = INF;
    for (int i = 1; i <= n; ++i) {
        if (bacon[i] < temp) {
            min = i;
            temp = bacon[i];
        }
    }
    cout << min;

    return 0;
}
