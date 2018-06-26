//
// Created by sks10 on 2018-06-25.
//
#include<algorithm>
#include <iostream>

using namespace std;

long long n, x, y;
int k, q;

void swap(long long &a, long long &b) {
    long long temp = a;
    a = b;
    b = temp;
}

int main() {
    // Fast I/O
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> k >> q;

    for (; q--;) {
        cin >> x >> y;

        if (k == 1) {
            // k = 1 일때는 노드의 크기 차이가 거리
            // 개행도 endl 이 매우 느리므로 \n 사용
            cout << abs(x - y) << "\n";
            continue;
        }

        int r = 0;
        // x, y 각 노드가 자신의 부모 노드로 이동한 거리를 구함
        // 같은 부모에 도달하면 끝
        while (x != y) {
            if (x < y)
                swap(x, y);
            // x를 부모노드로 변경
            x = ((x - 2) / k) + 1;
            r++;
        }
        cout << r << "\n";
    }
    return 0;
}