//
// Created by sks10 on 2018-02-24.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;
int visited[1001][1001];

struct Point {
    int a;
    int b;
};

Point around[4] = {{-1, 0},
                   {1,  0},
                   {0,  -1},
                   {0,  1}};

int tomato_day(int n, int m, const vector<vector<int>> &arr,
               const vector<pair<int, int>> &tomato) {
    queue<pair<int, int>> q;

    for (auto &i :tomato) {
        q.push(i);
        visited[i.first][i.second] = 1;

        while (!q.empty()) {
            pair<int, int> current = q.front();
            q.pop();

            for (auto &j : around) {
                int x = current.first + j.a;
                int y = current.second + j.b;

                if (x < 0 || y < 0)
                    continue;

                // 범위 내에 있고, 작은 값으로 갱신 가능하면 갱신
                if (x <= n - 1 && y <= m - 1 &&
                    (visited[x][y] == 0 || (visited[current.first][current.second] + 1 < visited[x][y]))) {
                    if (arr[x][y] == 0) {
                        q.push(make_pair(x, y));
                        visited[x][y] = visited[current.first][current.second] + 1;
                    } else
                        continue;
                }
            }
        }
    }
    // 모든 토마토가 익는 날짜 계산
    int temp = 0, max_day = 0;
    for (int k = 0; k < n; ++k) {
        for (int i = 0; i < m; ++i) {
            if (visited[k][i] == 0) {
                return -1;
            } else {
                if (visited[k][i] > temp) {
                    max_day = visited[k][i];
                    temp = max_day;
                }
            }
        }
    }
    return max_day - 1;
}

int main() {

    cin >> m >> n;

    // 상자
    vector<vector<int> > arr(n, vector<int>(m, 0));
    // 토마토가 들어간 위치
    vector<pair<int, int>> tomato;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> arr[i][j];
            if (arr[i][j] == 1) {
                // 토마토가 들어있는 위치 저장
                tomato.push_back(make_pair(i, j));
            } else if (arr[i][j] == -1) {
                visited[i][j] = -1;
            }
        }
    }
    cout << tomato_day(n, m, arr, tomato);

    return 0;
}
