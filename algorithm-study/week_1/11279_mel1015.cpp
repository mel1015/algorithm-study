//
// Created by sks10 on 2018-01-02.
//
#include <iostream>
#include <queue>

using namespace std;

int main() {

    // 우선순위 큐 : push 연산은 큐와 다를 바 없지만
    // pop을 할 때 반드시 존재하는 값들 중 가장 큰 값이 빠져나옴.
    priority_queue<int> pq;
    int n, x;

    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> x;

        if (x > 0) {
            pq.push(x);
        } else {
            if (pq.empty()) {
                cout << 0 << endl;
            } else {
                cout << pq.top() << endl;
                pq.pop();
            }
        }
    }
    return 0;
}