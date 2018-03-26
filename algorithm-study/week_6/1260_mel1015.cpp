//
// Created by sks10 on 2018-02-17.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool visited_dfs[1001];

void DFS(int n, int start, const vector<vector<int> > &arr) {
    visited_dfs[start] = true;
    cout << start << " ";

    for (int i = 1; i <= n; ++i) {
        if (!visited_dfs[i] && arr[start][i] == 1) {
            DFS(n, i, arr);
        }
    }
}

void BFS(int n, int start, const vector<vector<int> > &arr) {
    queue<int> q;
    bool visited[n + 1] = {false,};

    q.push(start);
    visited[start] = true;

    while (!q.empty()) {
        int current = q.front();
        cout << current << " ";
        q.pop();

        for (int i = 1; i <= n; ++i) {
            if (!visited[i] && arr[current][i] == 1) {
                q.push(i);
                visited[i] = true;
            }
        }
    }
}

int main() {
    int n, m, v;
    cin >> n >> m >> v;

    vector<vector<int> > arr(n + 1, vector<int>(n + 1, 0));

    int from, to;
    while (m--) {
        cin >> from >> to;
        arr[from][to] = 1;
        arr[to][from] = 1;
    }

    DFS(n, v, arr);
    cout << endl;
    BFS(n, v, arr);

    return 0;
}
