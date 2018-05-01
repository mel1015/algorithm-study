//
// Created by sks10 on 2018-05-01.
//
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n;
int visited[25][25];
vector<int> complex_size;

struct Point {
    int a;
    int b;
};

Point around[4] = {{-1, 0},
                   {1,  0},
                   {0,  -1},
                   {0,  1}};

int numbering(const vector<vector<int>> &map,
              const vector<pair<int, int>> &house) {

    queue<pair<int, int>> q;
    int complex = 0;

    for (auto i : house) {
        int size = 0;

        if (visited[i.first][i.second] == 0) {
            q.push(i);
            visited[i.first][i.second] = ++complex;
        } else
            continue;

        while (!q.empty()) {
            pair<int, int> current = q.front();
            q.pop();
            size++;

            for (auto &j : around) {
                int x = current.first + j.a;
                int y = current.second + j.b;

                if (x < 0 || y < 0 || x > n - 1 || y > n - 1)
                    continue;

                if (visited[x][y] == 0 && map[x][y] == 1) {
                    q.push(make_pair(x, y));
                    visited[x][y] = complex;
                }
            }
        }
        complex_size.emplace_back(size);
    }
    return complex;
}

int main() {
    cin >> n;

    vector<vector<int> > map(n, vector<int>(n, 0));
    vector<pair<int, int>> house;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            scanf("%1d", &map[i][j]);
            if (map[i][j] == 1)
                house.emplace_back(i, j);
        }
    }
    cout << numbering(map, house) << endl;
    sort(complex_size.begin(), complex_size.end());
    for (int k : complex_size) {
        cout << k << endl;
    }
    return 0;
}
