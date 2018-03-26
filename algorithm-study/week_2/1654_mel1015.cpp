//
// Created by sks10 on 2018-01-04.
//
#include <iostream>
#include <algorithm>

using namespace std;

int main() {

    int k, n, *landline, count = 0;
    // N의 범위가 1 ~ 1,000,000 이므로 int로 하면 오버플로우 발생
    long long sum = 0;

    cin >> k >> n;

    landline = new int[k];

    for (int i = 0; i < k; ++i) {
        cin >> landline[i];
        sum += landline[i];
    }
    sort(landline, landline + k);

    // 이분 탐색 : low = 0, high = 랜선길이의 총 합을 만들 개수 n으로 나눈 값
    long long low = 0, high = sum / n;
    // 기본 랜선의 최대길이 = high
    long long max_length = high;

    for (int i = 0; i < k; ++i) {
        // 최대 길이로 랜선들을 나누어서 개수를 셈
        count += landline[i] / high;
    }

    if (count >= n) {
        // 최대 길이로 나눈 개수가 목표 개수보다 크다면
        // 최대 길이가 나눌 수 있는 최대의 값
        cout << max_length;
    } else {
        // 이분 탐색 시작
        max_length = 0;
        while (low <= high) {
            count = 0;
            long long mid = (low + high) / 2;
            for (int i = 0; i < k; ++i) {
                count += landline[i] / mid;
            }
            if (count >= n) {
                low = mid + 1;
                if (max_length < low) {
                    max_length = low;
                }
            } else {
                high = mid - 1;
            }
        }
        cout << max_length - 1;
    }
    return 0;
}
