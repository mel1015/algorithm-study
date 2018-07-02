//
// Created by sks10 on 2018-07-02.
//
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> sum_row, sum_col, sum_diag;

int main() {
    int t;

    for (int i = 0; i < 10; ++i) {
        // 벡터 크기 초기화
        sum_row.resize(100);
        sum_col.resize(100);
        sum_diag.resize(2);

        cin >> t;

        int data;
        for (int j = 0; j < 100; ++j) {
            for (int k = 0; k < 100; ++k) {
                cin >> data;
                // 각 행의 모든 열의 합
                sum_row[j] += data;
                // 각 열의 모든 행의 합
                sum_col[k] += data;

                // 왼쪽 대각선
                if (j == k)
                    sum_diag[0] += data;
                // 오른쪽 대각선
                if (k + j == 99)
                    sum_diag[1] += data;
            }
        }
        // 각 벡터의 최댓값
        vector<int>::iterator max_row, max_col, max_diag;
        max_row = max_element(sum_row.begin(), sum_row.end());
        max_col = max_element(sum_col.begin(), sum_col.end());
        max_diag = max_element(sum_diag.begin(), sum_diag.end());

        // 최종 최댓값
        int biggest;
        biggest = max(*max_row, *max_col);
        biggest = max(biggest, *max_diag);

        cout << "#" << t << " " << biggest << "\n";

        // 벡터 원소 제거, 제거 후 벡터의 크기가 0으로 바뀜
        sum_row.clear();
        sum_col.clear();
        sum_diag.clear();
    }

    return 0;
}
