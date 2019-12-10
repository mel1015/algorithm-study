//
// Created by sks10 on 2019-04-06.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, minDiff = INT32_MAX;
vector<vector<int>> stats;
vector<int> pick;

void solution() {
    pick.resize(N);
    // 조합 구성
    for (int i = N / 2; i < pick.size(); ++i) {
        pick[i] = 1;
    }
    // permutation 을 사용하여 pick 배열 조합 변경
    do {
        int sumStart = 0, sumLink = 0;
        for (int i = 0; i < pick.size(); ++i) {
            for (int j = i + 1; j < pick.size(); ++j) {
                if (pick[i] && pick[j]) {
                    sumStart += stats[i][j] + stats[j][i];
                }
                if (!pick[i] && !pick[j]) {
                    sumLink += stats[i][j] + stats[j][i];
                }
            }
        }
        minDiff = min(minDiff, abs(sumStart - sumLink));
    } while (next_permutation(pick.begin(), pick.end()));
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    stats.resize(N);
    for (int i = 0; i < N; ++i) {
        stats[i].resize(N);
    }
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cin >> stats[i][j];
        }
    }
    solution();
    cout << minDiff;
    return 0;
}
