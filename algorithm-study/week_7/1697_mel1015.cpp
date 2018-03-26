//
// Created by sks10 on 2018-02-21.
//
#include <iostream>
#include <queue>

using namespace std;

// 방문 여부 및 시간 저장
int visited[100001];

int hide_and_seek(int n, int k) {
    // BFS
    queue<int> q;
    q.push(n);
    visited[n] = 1;

    while (!q.empty()) {
        int current = q.front();
        q.pop();

        int sub = current - 1, sum = current + 1, mul = current * 2;
        // 감소로 이동할 점은 0보다 커야하고, 해당 점을 방문하지 않았거나
        // 해당 이동을 통해 기존의 값보다 작은 값으로 갱신 가능하면
        if (sub >= 0 && (visited[sub] == 0 || visited[current] + 1 < visited[sub])) {
            q.push(sub);
            visited[sub] = visited[current] + 1;
        }
        // 증가로 이동할 점은 k보다 커질 필요가 없다
        if (sum <= k && (visited[sum] == 0 || visited[current] + 1 < visited[sum])) {
            q.push(sum);
            visited[sum] = visited[current] + 1;
        }
        // 곱으로 이동할 점은 최대 k + 1 이다
        // 곱으로 이동 한 점이 k + 1 보다 크면 그 후 모든 이동이 최소값이 아님
        if (mul <= k + 1 && (visited[mul] == 0 || visited[current] + 1 < visited[mul])) {
            q.push(mul);
            visited[mul] = visited[current] + 1;
        }
    }
    // 첫 위치부터 시간이 1로 계산되어 들어가므로 - 1 을 해주어야함
    return visited[k] - 1;
}

int main() {
    int n, k;

    cin >> n >> k;

    if (n > k) {
        // 동생보다 위치값이 크면 -1 연산을 n - k번 함
        cout << n - k;
    } else if (n == k) {
        // 같으면 0
        cout << 0;
    } else {
        cout << hide_and_seek(n, k);
    }

    return 0;
}
