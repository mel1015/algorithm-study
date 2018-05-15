//
// Created by sks10 on 2018-05-08.
//
#include <iostream>
#include <queue>

using namespace std;

int xp[4] = {1, -1, 0, 0};
int yp[4] = {0, 0, 1, -1};
int n, res;
vector<vector<int> > map;
vector<vector<int> > temp;

// 잠기는 지역 초기화
void make_map(int level) {
    temp = map;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (temp[i][j] <= level)
                temp[i][j] = 0;
        }
    }
}

void bfs(int level, int max, int count) {
    make_map(level);
    queue<pair<int, int>> q;

    // 이전 값보다 현재 값이 크면 갱신
    if (res < count) res = count;
    // 초기화
    count = 0;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (temp[i][j] != 0) {
                q.push(make_pair(i, j));
                temp[i][j] = 0;

                while (!q.empty()) {
                    pair<int, int> current = q.front();
                    q.pop();

                    for (int k = 0; k < 4; ++k) {
                        int x = current.first + xp[k];
                        int y = current.second + yp[k];

                        if (x < 0 || y < 0 || x > n - 1 || y > n - 1) continue;

                        if (temp[x][y] != 0) {
                            q.push(make_pair(x, y));
                            temp[x][y] = 0;
                        }
                    }
                }
                // 하나의 지역이 끝날 때 카운트 증가
                count++;
            }
        }
    }
    // 수위 증가
    level++;
    if (level <= max)
        bfs(level, max, count);
}

int main() {
    cin >> n;

    map.resize(n);
    for (int i = 0; i < n; ++i) {
        map[i].resize(n);
    }

    int max = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> map[i][j];
            // 가장 높은 지역
            if (map[i][j] > max)
                max = map[i][j];
        }
    }
    // 비는 0부터 max까지
    bfs(0, max, 0);
    cout << res;

    return 0;
}
