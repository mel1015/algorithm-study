//
// Created by sks10 on 2018-07-02.
//
#include <iostream>

using namespace std;

int arr[10][10];

// 진행 횟수
// n -> n-1 -> n-1 -> n-2 -> n-2 -> ... -> 1 -> 1
// 2번 진행 후 증감 값이 바뀜
int main() {
    // 테스트 횟수, 배열의 차수
    int t, n;

    cin >> t;
    for (int test = 1; test <= t; ++test) {
        cin >> n;
        cout << "#" << test << "\n";

        int cnt = 1;            // 원소 개수&값
        int row = 0, col = -1;  // 행과 열
        int inc = 1;            // 인덱스의 증감(진행 방향)
        int inc_time = n;       // 진행 횟수
        while (inc_time > 0) {
            // 열 증가 또는 감소
            for (int i = 0; i < inc_time; ++i) {
                col += inc;
                arr[row][col] = cnt++;
            }
            // 진행 횟수 감소
            inc_time--;
            // 진행 횟수가 0 이면 배열 완성
            if (inc_time == 0) break;
            // 행 증가 또는 감소
            for (int i = 0; i < inc_time; ++i) {
                row += inc;
                arr[row][col] = cnt++;
            }
            // 진행 방향 변경
            inc *= -1;
        }
        // 배열 출력
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cout << arr[i][j] << " ";
            }
            cout << "\n";
        }
    }
    return 0;
}
