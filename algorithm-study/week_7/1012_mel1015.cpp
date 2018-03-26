//
// Created by sks10 on 2018-03-14.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;
int visited[51][51];
vector<vector<int> > arr(51, vector<int>(51, 0));

struct Point {
    int a;
    int b;
};

Point around[4] = {{-1, 0},
                   {1,  0},
                   {0,  -1},
                   {0,  1}};

int earthworm(const vector<vector<int> > &arr, const vector<pair<int, int> > &worm) {
    queue<pair<int, int> > q;
    int count = 0;

    for (auto &i:worm) {
        // 방문하지 않은 위치만 큐에 삽입
        if (visited[i.first][i.second] == 0) {
            q.push(i);
            visited[i.first][i.second] = ++count;
        } else
            continue;

        while (!q.empty()) {
            pair<int, int> current = q.front();
            q.pop();

            for (auto &j:around) {
                // 현재 위치에서 상하좌우
                int x = current.first + j.a;
                int y = current.second + j.b;

                // 범위 확인
                if (x < 0 || y < 0 || x > n - 1 || y > m - 1)
                    continue;

                if (visited[x][y] == 0 && arr[x][y] == 1) {
                    q.push(make_pair(x, y));
                    visited[x][y] = count;
                }
            }
        }
    }
    return count;
}

int main() {

    int t, k;
    cin >> t;

    while (t--) {
        cin >> m >> n >> k;

        vector<pair<int, int> > worm;

        int x, y;
        for (int i = 0; i < k; ++i) {
            cin >> x >> y;
            arr[y][x] = 1;
            worm.emplace_back(y, x);
        }
        cout << earthworm(arr, worm) << endl;

        // 초기화
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                arr[j][i] = 0;
                visited[j][i] = 0;
            }
        }
        worm.clear();
    }
    return 0;
}
