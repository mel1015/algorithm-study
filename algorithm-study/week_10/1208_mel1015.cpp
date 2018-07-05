//
// Created by sks10 on 2018-07-05.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> boxes;
int dump;

int go_dump() {
    vector<int>::iterator high, low;
    int result = 0;
    while (dump--) {
        // 벡터의 최댓값과 최솟값
        // 상자의 최고점과 최저점
        high = max_element(boxes.begin(), boxes.end());
        low = min_element(boxes.begin(), boxes.end());

        // 평탄화가 완료되었을 경우
        if (*high - *low <= 1) {
            result = *high - *low;
            return result;
        }
        // 최대값과 최소값 갱신
        *high = *high - 1;
        *low = *low + 1;
    }
    // 결과
    high = max_element(boxes.begin(), boxes.end());
    low = min_element(boxes.begin(), boxes.end());
    result = *high - *low;
    return result;
}

int main() {

    for (int times = 1; times <= 10; ++times) {
        cin >> dump;
        boxes.resize(100);
        for (int i = 0; i < 100; ++i) {
            cin >> boxes[i];
        }
        cout << "#" << times << " " << go_dump() << "\n";
        boxes.clear();
    }
    return 0;
}