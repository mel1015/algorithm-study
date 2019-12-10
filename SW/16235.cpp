//
// Created by sks10 on 2019-05-17.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>

#define endl "\n"

using namespace std;

int N, M, K;
vector<vector<int>> map;
vector<vector<int>> food;
vector<vector<vector<int>>> tree;

int dx[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[8] = {-1, 0, 1, -1, 1, -1, 0, 1};

void SpringAndSummer() {
    // 양분 섭취, 죽은 나무 양분으로
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            if (!tree[i][j].empty()) {
                sort(tree[i][j].begin(), tree[i][j].end());
                int toFood = 0;
                vector<int> temp;
                for (int k = 0; k < tree[i][j].size(); ++k) {
                    if ((map[i][j] - tree[i][j][k]) >= 0) {
                        map[i][j] -= tree[i][j][k];
                        temp.push_back(tree[i][j][k] + 1);
                    } else {
                        toFood += tree[i][j][k] / 2;
                    }
                }
                tree[i][j].clear();
                tree[i][j] = temp;
                map[i][j] += toFood;
            }
        }
    }
}

void FallAndWinter() {
    // 가을 => 나무 번식
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            if (!tree[i][j].empty()) {
                for (int k = 0; k < tree[i][j].size(); ++k) {
                    if ((tree[i][j][k] % 5) == 0) {
                        for (int l = 0; l < 8; ++l) {
                            int nx = i + dx[l];
                            int ny = j + dy[l];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                tree[nx][ny].push_back(1);
                            }
                        }
                    }
                }
            }
            // 겨울 => 양분 추가
            map[i][j] += food[i][j];
        }
    }
}

void printMap() {
    cout << "Trees" << endl;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cout << setw(3) << tree[i][j].size();
        }
        cout << endl;
    }
    cout << "Foods" << endl;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cout << setw(3) << map[i][j];
        }
        cout << endl;
    }
}

int Solution() {
//    cout << "Initial" << endl;
//    printMap();
    for (int i = 1; i <= K; ++i) {
        SpringAndSummer();
        FallAndWinter();
//        cout << "After " << i << "years" << endl;
//        printMap();
    }
    int countTrees = 0;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            countTrees += tree[i][j].size();
        }
    }
    return countTrees;
}

void init() {
    cin >> N >> M >> K;
    // 맵, 겨울에 추가할 양분
    map.resize(N);
    food.resize(N);
    tree.resize(N);
    for (int i = 0; i < N; ++i) {
        map[i].resize(N);
        food[i].resize(N);
        tree[i].resize(N);
        for (int j = 0; j < N; ++j) {
            cin >> food[i][j];
            map[i][j] = 5;
        }
    }
    // 나무 정보
    for (int i = 0; i < M; ++i) {
        int x, y, z;
        cin >> x >> y >> z;
        tree[x - 1][y - 1].push_back(z);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);

    init();
    cout << Solution() << endl;

    return 0;
}
