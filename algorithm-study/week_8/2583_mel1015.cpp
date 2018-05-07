//
// Created by sks10 on 2018-05-07.
//
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n, m;
int map[101][101];
vector<int> area_size;

struct Point {
    int a;
    int b;
};

Point around[4] = {{-1, 0},
                   {1,  0},
                   {0,  -1},
                   {0,  1}};

void count_area(int n, int m) {
    queue<pair<int, int>> q;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            int size = 0;

            if (map[i][j] == 0) {
                q.push(make_pair(i, j));
                map[i][j] = 1;

                while (!q.empty()) {
                    pair<int, int> current = q.front();
                    q.pop();
                    size++;

                    for (auto &k : around) {
                        int x = current.first + k.a;
                        int y = current.second + k.b;

                        if (x < 0 || y < 0 || x > n - 1 || y > m - 1)
                            continue;

                        if (map[x][y] == 0) {
                            q.push(make_pair(x, y));
                            map[x][y] = 1;
                        }
                    }
                }
                area_size.push_back(size);
            }
        }
    }
}

int main() {
    int k;
    cin >> m >> n >> k;

    for (int i = 0; i < k; ++i) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        for (int j = x1; j < x2; ++j) {
            for (int l = y1; l < y2; ++l) {
                map[j][l] = 1;
            }
        }
    }
    count_area(n, m);
    sort(area_size.begin(), area_size.end());

    cout << area_size.size() << endl;
    for (int i1 : area_size) {
        cout << i1 << " ";
    }

    return 0;
}
