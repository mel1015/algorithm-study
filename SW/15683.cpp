//
// Created by sks10 on 2019-04-08.
//
#include <iostream>
#include <vector>

using namespace std;

int N, M, answer = INT32_MAX;
vector<vector<int>> map;
vector<pair<int, int>> cctv;

vector<vector<int>> overSee(vector<vector<int>> visited, int x, int y, int dir) {
    switch (dir) {
        case 0:
            //상
            for (int i = x; i >= 0; --i) {
                if (map[i][y] == 6) break;
                visited[i][y] = -1;
            }
            return visited;
        case 1:
            //좌
            for (int j = y; j >= 0; --j) {
                if (map[x][j] == 6) break;
                visited[x][j] = -1;
            }
            return visited;
        case 2:
            //하
            for (int i = x; i < N; ++i) {
                if (map[i][y] == 6) break;
                visited[i][y] = -1;
            }
            return visited;
        case 3:
            //우
            for (int j = y; j < M; ++j) {
                if (map[x][j] == 6) break;
                visited[x][j] = -1;
            }
            return visited;
        default:
            break;
    }
}

void check(int cctvIndex, vector<vector<int>> prev) {
    if (cctvIndex == cctv.size()) {
        int count = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (prev[i][j] == 0) count++;
            }
        }
        answer = min(answer, count);
    } else {
        int x = cctv[cctvIndex].first;
        int y = cctv[cctvIndex].second;
        int cctvNum = map[x][y];
        switch (cctvNum) {
            case 1:
                // 0 상, 1 좌, 2 하, 3 우
                for (int i = 0; i < 4; ++i) {
                    // 이전 배열을 가져와
                    vector<vector<int>> visited = prev;
                    // 감시 함수에 사용 후, 변경 값으로 갱신
                    visited = overSee(visited, x, y, i);
                    // 다음 CCTV로 배열을 넘겨줌
                    check(cctvIndex + 1, visited);
                }
                break;
            case 2:
                // (상, 하), (좌, 우)
                for (int i = 0; i < 2; ++i) {
                    vector<vector<int>> visited = prev;
                    visited = overSee(visited, x, y, i);
                    visited = overSee(visited, x, y, i + 2);
                    check(cctvIndex + 1, visited);
                }
                break;
            case 3:
                // (상, 좌), (좌, 하), (하, 우), (우, 상)
                for (int i = 0; i < 4; ++i) {
                    vector<vector<int>> visited = prev;
                    visited = overSee(visited, x, y, i);
                    visited = overSee(visited, x, y, (i + 1) % 4);
                    check(cctvIndex + 1, visited);
                }
                break;
            case 4:
                // (상, 좌, 하), (좌, 하, 우), (하, 우, 상), (우, 상, 좌)
                for (int i = 0; i < 4; ++i) {
                    vector<vector<int>> visited = prev;
                    visited = overSee(visited, x, y, i);
                    visited = overSee(visited, x, y, (i + 1) % 4);
                    visited = overSee(visited, x, y, (i + 2) % 4);
                    check(cctvIndex + 1, visited);
                }
                break;
            case 5:
                // (상, 좌, 하, 우)
                vector<vector<int>> visited = prev;
                visited = overSee(visited, x, y, 0);
                visited = overSee(visited, x, y, 1);
                visited = overSee(visited, x, y, 2);
                visited = overSee(visited, x, y, 3);
                check(cctvIndex + 1, visited);
                break;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    map.resize(N);
    for (int i = 0; i < N; ++i) {
        map[i].resize(M);
        for (int j = 0; j < M; ++j) {
            cin >> map[i][j];
            if (map[i][j] > 0 && map[i][j] < 6)
                cctv.emplace_back(i, j);
        }
    }
    check(0, map);
    cout << answer;
    return 0;
}
