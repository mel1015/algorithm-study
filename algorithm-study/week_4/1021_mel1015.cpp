//
// Created by sks10 on 2018-01-22.
//
#include <iostream>
#include <deque>

using namespace std;

int main() {
    deque<int> mydeque, left, right;
    int n, m, *find, result = 0;

    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        // 덱을 1, 2, 3, ..., n으로 초기화
        mydeque.push_back(i);
    }

    // 뽑아내려고 하는 수를 입력 받을 배열
    find = new int[m];

    for (int i = 0; i < m; ++i) {
        cin >> find[i];

        if (mydeque.front() == find[i]) {
            // 뽑아내려는 수가 덱의 첫번째에 있을 경우
            // 2번 3번 연산의 횟수를 증가할 필요가 없으므로
            mydeque.pop_front();
            continue;
        }

        // 왼쪽으로 돌릴 덱(left)과 오른쪽으로 돌릴 덱(right)을
        // clear()를 통해 초기화 후 현재 덱(mydeque)을 복사
        left.clear();
        right.clear();
        left = right = mydeque;
        mydeque.clear();

        // 연산 횟수 저장할 변수
        int count_left = 0, count_right = 0;
        while (true) {
            // 왼쪽으로 회전하며 찾는 연산
            if (left.front() == find[i]) {
                left.pop_front();
                break;
            }
            // left덱의 마지막 요소 뒤에 첫번째 요소를 추가
            left.push_back(left.front());
            // 첫번째 요소를 제거
            left.pop_front();
            count_left++;
        }

        while (true) {
            // 오른쪽으로 회전하며 찾는 연산
            if (right.front() == find[i]) {
                right.pop_front();
                break;
            }
            // right덱의 마지막 요소를 맨 앞에 추가
            right.push_front(right.back());
            // 마지막 요소를 제거
            right.pop_back();
            count_right++;
        }

        // 왼쪽으로 회전하여 찾은 횟수와
        // 오른쪽으로 회전하여 찾은 횟수 중
        // 작은 것을 결과값에 더함
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
