//
// Created by sks10 on 2018-09-13.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Point {
    int a;
    int b;
};

// 상하좌우
Point around[4] = {{-1, 0},
                   {1,  0},
                   {0,  -1},
                   {0,  1}};

vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int visited[101][101] = {0,};
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    queue<pair<int, int>> q;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; ++j) {
            if (picture[i][j] != 0) {
                int pic_num = picture[i][j];
                int size = 0;

                // 영역 개수 증가
                if (visited[i][j] == 0) {
                    q.push(make_pair(i, j));
                    visited[i][j] = ++number_of_area;
                } else continue;

                // BFS
                while (!q.empty()) {
                    pair<int, int> current = q.front();
                    q.pop();
                    size++;

                    for (auto &k : around) {
                        int x = current.first + k.a;
                        int y = current.second + k.b;

                        if (x < 0 || y < 0 || x > m - 1 || y > n - 1) continue;
                        if (visited[x][y] == 0 && picture[x][y] == pic_num) {
                            q.push(make_pair(x, y));
                            visited[x][y] = number_of_area;
                        }
                    }
                }
                if (size > max_size_of_one_area) max_size_of_one_area = size;
            }
        }
    }

    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}


int main() {
    int m, n;
    cin >> m >> n;
    vector<vector<int>> picture;
    picture.resize(m);
    for (int i = 0; i < m; ++i) {
        picture[i].resize(n);
    }

    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> picture[i][j];
        }
    }
    vector<int> answer(2);
    answer = solution(m, n, picture);
    for (int k : answer) {
        cout << k << " ";
    }
    return 0;
}

