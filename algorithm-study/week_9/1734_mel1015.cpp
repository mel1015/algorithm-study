//
// Created by sks10 on 2018-06-29.
//
// 메모리 초과
// 정점 개수가 100,000개 까지이므로
// 큐에 쓸모없는 데이터가 너무 많이 쌓임
// 단절점, 단절선 공부 필요
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<int> map[100010];
int n, e, q;

void solve(int a, int b, int c, int d) {
    vector<int>::iterator it;
    it = find(map[a].begin(), map[a].end(), b);
    if (it != map[a].end()) {
        cout << "yes\n";
        return;
    }

    queue<pair<int, int>> que;
    for (int i : map[a]) {
        que.push(make_pair(a, i));

        while (!que.empty()) {
            pair<int, int> current = que.front();
            que.pop();

            for (int j : map[current.second]) {
                if (current.first == j) continue;
                if (current == make_pair(c, d) || current == make_pair(d, c)) continue;
                que.push(make_pair(current.second, j));
                if (j == b) {
                    cout << "yes\n";
                    return;
                }
            }
        }
    }
    cout << "no\n";
}

void solve(int a, int b, int c) {
    vector<int>::iterator it;
    it = find(map[a].begin(), map[a].end(), b);
    if (it != map[a].end()) {
        cout << "yes\n";
        return;
    }

    queue<pair<int, int>> que;
    for (int i : map[a]) {
        if (i == c) continue;
        que.push(make_pair(a, i));

        while (!que.empty()) {
            pair<int, int> current = que.front();
            que.pop();

            for (int j : map[current.second]) {
                if (j == c) continue;
                if (current.first == j) continue;
                que.push(make_pair(current.second, j));
                if (j == b) {
                    cout << "yes\n";
                    return;
                }
            }
        }
    }
    cout << "no\n";
}

int main() {
    cin >> n >> e;

    int x, y;
    while (e--) {
        cin >> x >> y;
        map[x].push_back(y);
        map[y].push_back(x);
    }
    cin >> q;

    int q_num, a, b, c, d;
    while (q--) {
        scanf("%d", &q_num);
        if (q_num == 1) {
            cin >> a >> b >> c >> d;
            solve(a, b, c, d);
        } else {
            cin >> a >> b >> c;
            solve(a, b, c);
        }
    }
    return 0;
}
