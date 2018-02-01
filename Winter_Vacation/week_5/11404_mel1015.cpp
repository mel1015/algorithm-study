//
// Created by sks10 on 2018-02-01.
//
#include <iostream>

using namespace std;

#define INF 100001

// D : 최소 비용 테이블
int D[101][101];
// P : 최소 비용 경로가 거쳐야 할 마지막 경유지 테이블
int P[101][101];
// W : 초기 비용 테이블
int W[101][101];

void doFloyd(int N) {

    // 최소 비용 테이블 초기화
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {
            D[i][j] = W[i][j];
        }
    }

    // 플로이드 워셜 알고리즘 시작
    for (int k = 1; k <= N; ++k) {
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (i == j) continue;

                if (D[i][j] > D[i][k] + D[k][j]) {
                    P[i][j] = k;
                    D[i][j] = D[i][k] + D[k][j];
                }
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    // 초기 비용 테이블을 무한대로 초기화
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            W[i][j] = INF;
        }
    }

    while (m--) {
        int from, to, cost;
        cin >> from >> to >> cost;

        // 초기 비용 테이블 입력
        if (W[from][to] == 0 || W[from][to] > cost) {
            W[from][to] = cost;
        } else if (W[from][to] < cost) {
            continue;
        }
    }

    doFloyd(n);

    // 최소 비용 테이블 출력
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (D[i][j] == INF) {
                cout << "0 ";
            } else {
                cout << D[i][j] << " ";
            }
        }
        cout << endl;
    }
    cout << endl;

    return 0;
}