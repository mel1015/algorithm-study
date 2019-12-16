//
// Created by sks10 on 2019-06-10.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <iomanip>

#define endl "\n"

using namespace std;

int N, M, Answer = 987654321, countSpace = 0;
vector<vector<int>> map;
vector<pair<int, int>> virus;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

void bfs(vector<int> combi) {
    int countVirus = 0, time = 0;
    vector<vector<int>> timeMap(N, vector<int>(N, -1));
    queue<pair<int, int>> q;

    // 활성화된 바이러스들을 큐에 넣고
    // timeMap에 0초로 체크
    for (int i = 0; i < combi.size(); ++i) {
        if (combi[i]) {
            q.push({virus[i].first, virus[i].second});
            timeMap[virus[i].first][virus[i].second] = 0;
        }
    }

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (map[nx][ny] != 1 && timeMap[nx][ny] == -1) {
                timeMap[nx][ny] = timeMap[x][y] + 1;
                if (map[nx][ny] == 0) {
                    countVirus++;
                    time = timeMap[nx][ny];
                }
                q.push({nx, ny});
            }
        }
    }
    if (countVirus == countSpace && Answer > time) Answer = time;
}

void solution() {
    // next_permutation() 사용
    vector<int> combi(virus.size());
    for (int i = 0; i < M; ++i) {
        combi[i] = 1;
    }
    sort(combi.begin(), combi.end());
    do {
        bfs(combi);
    } while (next_permutation(combi.begin(), combi.end()));

    if (Answer == 987654321) cout << -1;
    else cout << Answer;
}

void init() {
    cin >> N >> M;
    map.resize(N);
    for (int i = 0; i < N; ++i) {
        map[i].resize(N);
        for (int j = 0; j < N; ++j) {
            cin >> map[i][j];
            if (map[i][j] == 2) {
                // 바이러스 위치 저장
                virus.emplace_back(i, j);
            } else if (map[i][j] == 0) {
                // 빈 공간의 개수 체크
                countSpace++;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    init();
    solution();

    return 0;
}