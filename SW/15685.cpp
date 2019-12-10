//
// Created by sks10 on 2019-04-09.
//
#include <iostream>
#include <vector>

using namespace std;

int map[101][101];
vector<int> dragonDir;

int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);

    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        // x 가로, y 세로
        int y, x, d, g;
        cin >> y >> x >> d >> g;
        // 0 세대
        dragonDir.clear();
        map[x][y] = 1;
        x += dx[d];
        y += dy[d];
        map[x][y] = 1;
        // 방향 넣고 다음 방향은 (d + 1) % 4
        dragonDir.push_back(d);
        for (int j = 0; j < g; ++j) {
            for (int k = dragonDir.size() - 1; k >= 0; --k) {
                int dir = (dragonDir[k] + 1) % 4;
                x += dx[dir];
                y += dy[dir];
                map[x][y] = 1;
                dragonDir.push_back(dir);
            }
        }
    }
    int result = 0;
    for (int i = 0; i <= 100; i++) {
        for (int j = 0; j <= 100; j++) {
            if (map[i][j] && map[i][j + 1] && map[i + 1][j]
                && map[i + 1][j + 1]) {
                result++;
            }
        }
    }
    cout << result << endl;
    return 0;
}