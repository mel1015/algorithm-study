//
// Created by sks10 on 2019-04-09.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, answer = INT32_MAX;
int map[51][51];
vector<pair<int, int>> home;
vector<pair<int, int>> chicken;

int homeToChicken(vector<int> combi) {
    vector<int> distance(home.size(), INT32_MAX);
    int sum = 0;
    for (int i = 0; i < home.size(); ++i) {
        for (int j = 0; j < combi.size(); ++j) {
            if (combi[j]) {
                int x = abs(home[i].first - chicken[j].first);
                int y = abs(home[i].second - chicken[j].second);
                distance[i] = min(distance[i], x + y);
            }
        }
        sum += distance[i];
    }
    return sum;
}

void solution() {
    vector<int> combi(chicken.size());
    for (int i = 0; i < M; ++i) {
        combi[i] = 1;
    }
    sort(combi.begin(), combi.end());
    do {
        answer = min(answer, homeToChicken(combi));
    } while (next_permutation(combi.begin(), combi.end()));
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);

    cin >> N >> M;
    // M개의 치킨집만 남기고 다 폐업
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cin >> map[i][j];
            if (map[i][j] == 1) home.emplace_back(i, j);
            else if (map[i][j] == 2) chicken.emplace_back(i, j);
        }
    }
    solution();
    cout << answer;
    return 0;
}
