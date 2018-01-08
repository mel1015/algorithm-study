//
// Created by sks10 on 2018-01-04.
//
#include <iostream>
#include <algorithm>

using namespace std;

int main() {

    int n, m, *budget;
    int sum = 0;

    cin >> n;

    // 배열 동적 할당
    budget = new int[n];

    for (int i = 0; i < n; ++i) {
        cin >> budget[i];
        sum += budget[i];
    }
    // 배열 정렬
    sort(budget, budget + n);

    cin >> m;

    // 이분 탐색 : low = 0, high = 지방 예산의 최대값
    // 할당 가능한 최대 예산 : upper_budget
    int low = 0, high = budget[n - 1], upper_budget = 0;;

    if (sum < m) {
        // 지방 예산의 합이 국가예산을 안넘으면
        // 지방 예산의 최대값을 출력
        cout << high;
    } else {
        // 이분 탐색 시작
        while (low <= high) {
            int mid = (low + high) / 2;
            int possible_budget = 0;

            for (int i = 0; i < n; ++i) {
                if (budget[i] > mid) {
                    possible_budget += mid;
                } else {
                    possible_budget += budget[i];
                }
            }

            if (possible_budget > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
                if (upper_budget < mid) {
                    upper_budget = mid;
                }
            }
        }
        cout << upper_budget;
    }
    return 0;
}