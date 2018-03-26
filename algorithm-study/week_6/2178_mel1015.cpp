//
// Created by sks10 on 2018-02-12.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 좌표를 표현하기 위한 구조체
struct POINT {
    int a;
    int b;
};

// 상하좌우
POINT around[4] = {{1,  0},
                   {-1, 0},
                   {0,  1},
                   {0,  -1}};

int find_route(int n, int m, const vector<vector<int> > &arr) {
    // 좌표는 x, y 값이 쌍으로 있으므로 pair 사용
    queue<pair<int, int>> q;
    // 해당 좌표에 방문 여부와 해당 좌표까지의 이동 칸 수를 저장
    int visited[n + 1][m + 1] = {0,};

    // 시작은 항상 (1, 1)
    q.push(make_pair(1, 1));
    visited[1][1] = 1;

    // BFS 시작
    while (!q.empty()) {
        // 현재 위치
        pair<int, int> current = q.front();
        q.pop();

        // 도착
        if (current.first == n && current.second == m) break;

        for (auto &i : around) {
            // 현재 위치에서 상하좌우의 좌표
            int x = current.first + i.a;
            int y = current.second + i.b;

            // 해당 좌표가 방문하지 않은 곳이고, 미로에서 이동 가능한 위치인지,
            // 미로의 범위 내 있는지 확인
            if (!visited[x][y] && arr[x][y] == 1 && x <= n && y <= m) {
                q.push(make_pair(x, y));
                // 이동할 위치에 현재까지의 이동거리 + 1 저장
                visited[x][y] = visited[current.first][current.second] + 1;
            }
        }
    }
    return visited[n][m];
}


int main() {
    int n, m;

    cin >> n >> m;

    // 좌표가 1부터 시작하며 주어진 미로의 상하좌우에 0 값이 들어가야 하므로
    // 크기가 가로 n + 2, 세로 m + 2
    vector<vector<int> > arr(n + 2, vector<int>(m + 2, 0));

    // 미로 데이터가 숫자 열로 들어오므로 스트링으로 열을 입력 받음
    string map_data[n + 1];
    for (int i = 1; i <= n; ++i) {
        cin >> map_data[i];
    }

    // 스트링으로 입력 받은 값을 정수형으로 바꾸어 맵에 저장
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            arr[i][j] = map_data[i][j - 1] - 48;
        }
    }

    cout << find_route(n, m, arr);

    return 0;
}