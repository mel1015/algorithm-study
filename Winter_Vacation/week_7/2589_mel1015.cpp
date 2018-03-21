//
// Created by sks10 on 2018-03-14.
//
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n, m;
int visited[51][51];

struct Point {
    int a;
    int b;
};

Point around[4] = {{-1, 0},
                   {1,  0},
                   {0,  -1},
                   {0,  1}};

int treasure(const vector<vector<char> > &arr, const vector<pair<int, int> > &land) {
    queue<pair<int, int> > q;
    int max = 0;

    // land 배열에 있는 각각의 육지 좌표를 시작점으로하여 탐색 시작
    // 가장 오래걸린 시간이 답
    for (auto &i:land) {
        q.push(i);
        visited[i.first][i.second] = 1;

        while (!q.empty()) {
            pair<int, int> current = q.front();
            q.pop();

            for (auto &j:around) {
                int x = current.first + j.a;
                int y = current.second + j.b;

                // 범위 확인
                if (x < 0 || y < 0 || x > n || y > m)
                    continue;

                // 육지이고 방문하지 않았다면
                if (arr[x][y] == 'L' && visited[x][y] == 0) {
                    q.push(make_pair(x, y));
                    visited[x][y] = visited[current.first][current.second] + 1;
                }
            }
        }

        // visited 배열의 최대값 탐색
        for (int l = 0; l < n; ++l) {
            int temp = *max_element(visited[l], visited[l] + m);
            if (temp > max)
                max = temp;
        }

        // 다음 좌표에서 또 다시 BFS를 하므로 초기화
        for (int k = 0; k < n; ++k) {
            for (int j = 0; j < m; ++j) {
                visited[k][j] = 0;
            }
        }
    }
    return max - 1;
}

int main() {
    cin >> n >> m;

    vector<vector<char> > arr(n + 1, vector<char>(m + 1, 0));
    vector<pair<int, int> > land;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> arr[i][j];

            // 육지 좌표 저장
            if (arr[i][j] == 'L')
                land.emplace_back(i, j);
        }
    }
    cout << treasure(arr, land);

    return 0;
}
