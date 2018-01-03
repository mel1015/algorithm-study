//
// Created by sks10 on 2018-01-02.
//
#include <iostream>
#include <queue>

using namespace std;

int main() {

    // 두 번째 형 변수는 자료구조의 연동 컨테이너
    // 값의 저장 방식이 해당 자료구조와 동일
    // 세 번째 형 변수는 비교에 사용할 연산
    // greater는 작은 수 부터 큐에서 빠져나옴 기본값은 less.
    priority_queue<int, vector<int>, greater<int> > pq;
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