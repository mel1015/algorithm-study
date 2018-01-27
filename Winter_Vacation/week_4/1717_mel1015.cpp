//
// Created by sks10 on 2018-01-17.
//
#include <iostream>
#include <vector>

using namespace std;

// 서로소 집합 클래스
class DisjointSet {
private:
    vector<int> parent, rank;

public:
    // 초기화 리스트를 통해 멤버 변수 초기화
    DisjointSet(int n) : parent(n), rank(n, 1) {
        for (int i = 0; i <= n; ++i) {
            parent[i] = i;
        }
    }

    // parent 노드를 찾는 함수
    int find(int a) {
        if (a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }

    // 집합을 합치는 함수
    void merge(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b)
            return;

        // 랭크가 작은 것을 큰 것에 붙임
        // 랭크가 같을 경우 합치고 랭크를 증가 시킴
        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else if (rank[a] == rank[b]) {
            parent[b] = a;
            rank[a]++;
        } else {
            parent[a] = b;
        }
    }
};

int main() {

    int n, m;
    scanf("%d%d", &n, &m);

    DisjointSet *ds = new DisjointSet(n);

    int cmd, a, b;
    while (m--) {
        scanf("%d%d%d", &cmd, &a, &b);
        if (cmd == 0) {
            // 합집합
            ds->merge(a, b);
        } else if (cmd == 1) {
            if (ds->find(a) == ds->find(b)) {
                // 같은 집합에 포함되어 있을 때
                printf("YES\n");
            } else {
                // 다른 집합
                printf("NO\n");
            }
        }
    }
    return 0;
}
