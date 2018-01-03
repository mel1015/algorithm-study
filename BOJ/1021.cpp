//
// Created by sks10 on 2017-09-19.
//
// 덱에 초기 상태를 넣어놓고
// 왼쪽과 오른쪽으로 각각 회전 시켰을 때
// 찾는 수가 몇 번 회전 후에 나오는지 계산하고
// 회전 수가 적은 덱을 초기 덱으로 초기화하고
// 다음 수를 찾는다.

#include <iostream>
#include <deque>

using namespace std;

int main() {
    deque<int> mydeque, left, right;
    int n, m, *find, result = 0;

    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        mydeque.push_back(i);
    }

    find = new int[m];

    for (int i = 0; i < m; ++i) {
        cin >> find[i];

        if (mydeque.front() == find[i]) {
            mydeque.pop_front();
            continue;
        }

        left.clear();
        right.clear();
        left = right = mydeque;
        mydeque.clear();

        int count_left = 0, count_right = 0;

        while (1) {
            if (left.front() == find[i]) {
                left.pop_front();
                break;
            }
            left.emplace_back(left.front());
            left.pop_front();
            count_left++;
        }

        while (1) {
            if (right.front() == find[i]) {
                right.pop_front();
                break;
            }
            right.emplace_front(right.back());
            right.pop_back();
            count_right++;
        }

        if (count_left < count_right) {
            result += count_left;
            mydeque = left;
        } else {
            result += count_right;
            mydeque = right;
        }
    }
    cout << result << endl;

    return 0;
}