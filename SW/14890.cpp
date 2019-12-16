//
// Created by sks10 on 2019-04-06.
//
#include <iostream>
#include <vector>

using namespace std;

int N, L, answer = 0;
vector<vector<int>> map;
vector<vector<bool>> visited;

bool desc(int i, int j, int dir) {
    // 1이면 가로 0이면 세로
    int count = 0;
    vector<vector<bool>> temp = visited;
    if (dir) {
        for (int k = j; k < N; ++k) {
            // 현재칸부터 L개의 칸이 같은 높이이고
            // 경사로를 짓지 않았으면 true 반환
            if (map[i][k] == map[i][j] && !visited[i][k]) {
                count++;
                visited[i][k] = true;
                if (count == L) return true;
            } else {
                // 경사로 유무 배열 초기화
                visited = temp;
                return false;
            }
        }
    } else {
        for (int k = i; k < N; ++k) {
            if (map[k][j] == map[i][j] && !visited[k][j]) {
                count++;
                visited[k][j] = true;
                if (count == L) return true;
            } else {
                visited = temp;
                return false;
            }
        }
    }
    return false;
}

bool asc(int i, int j, int dir) {
    // 1이면 가로 0이면 세로
    int count = 0;
    vector<vector<bool>> temp = visited;
    if (dir) {
        for (int k = j; k >= 0; --k) {
            if (map[i][k] == map[i][j] && !visited[i][k]) {
                count++;
                visited[i][k] = true;
                if (count == L) return true;
            } else {
                visited = temp;
                return false;
            }
        }
    } else {
        for (int k = i; k >= 0; --k) {
            if (map[k][j] == map[i][j] && !visited[k][j]) {
                count++;
                visited[k][j] = true;
                if (count == L) return true;
            } else {
                visited = temp;
                return false;
            }
        }
    }
    return false;
}

void solution() {
    // 세로로로 체크하기 위해 지도를 백업해둠
    vector<vector<bool>> temp = visited;
    // 가로 체크
    // 현재 칸과 이전 칸의 높이 차가 1이상이면 다음 행으로
    // -1이면 내리막길(desc), 1이면 오르막길(asc)
    // 내리막길이면 현재 칸부터 L개 비교
    // 오르막길이면 이전 칸부터 L개 비교
    int prevHeight = 0, curHeight = 0;
    for (int i = 0; i < N; ++i) {
        bool isRoad = true;
        prevHeight = map[i][0];
        for (int j = 1; j < N; ++j) {
            curHeight = map[i][j];
            int diff = curHeight - prevHeight;
            if (abs(diff) > 1) {
                isRoad = false;
                break;
            } else if (diff == 1) {
                if (!asc(i, j - 1, 1)) {
                    isRoad = false;
                    break;
                }
            } else if (diff == -1) {
                if (!desc(i, j, 1)) {
                    isRoad = false;
                    break;
                }
            }
            prevHeight = map[i][j];
        }
        if (isRoad) {
//            cout << i << "행 가능" << endl;
            answer++;
        }
    }
    // 세로 체크
    visited = temp;
    for (int j = 0; j < N; ++j) {
        bool isRoad = true;
        prevHeight = map[0][j];
        for (int i = 1; i < N; ++i) {
            curHeight = map[i][j];
            int diff = curHeight - prevHeight;
            if (abs(diff) > 1) {
                isRoad = false;
                break;
            } else if (diff == 1) {
                if (!asc(i - 1, j, 0)) {
                    isRoad = false;
                    break;
                }
            } else if (diff == -1) {
                if (!desc(i, j, 0)) {
                    isRoad = false;
                    break;
                }
            }
            prevHeight = map[i][j];
        }
        if (isRoad) {
//            cout << j << "열 가능" << endl;
            answer++;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> L;
    map.resize(N);
    visited.resize(N);
    for (int i = 0; i < N; ++i) {
        map[i].resize(N);
        visited[i].resize(N);
    }
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cin >> map[i][j];
        }
    }
    solution();
    cout << answer;
    return 0;
}
