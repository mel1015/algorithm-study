//
// Created by sks10 on 2018-03-26.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> graph[20001];
vector<int> coloring(20001, 0);

bool BFS(int start) {
    queue<int> q;

    q.push(start);
    coloring[start] = 1;

    while (!q.empty()) {
        int current = q.front();
        q.pop();

        for (int i = 0; i < graph[current].size(); i++) {
            int next = graph[current][i];

            if (coloring[next] == 0) {
                coloring[next] = ~coloring[current];
                q.push(next);
            } else {
                if (coloring[next] == coloring[current])
                    return false;
            }
        }
    }

    return true;
}

int main() {
    int K, V, E;
    cin >> K;

    while (K--) {
        int v1, v2;
        bool res = true;

        cin >> V >> E;

        // 초기화
        for (int i = 1; i <= V; i++)
            graph[i].clear();
        coloring.assign(V + 1, 0);

        // 입력
        for (int i = 0; i < E; i++) {
            cin >> v1 >> v2;
            graph[v1].push_back(v2);
            graph[v2].push_back(v1);
        }

        // 시작점 탐색 & BFS 시작
        for (int i = 1; i <= V; i++) {
            if (coloring[i] == 0)
                res &= BFS(i);
        }

        if (res)
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
    }
    return 0;
}