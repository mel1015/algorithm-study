//
// Created by sks10 on 2018-01-23.
//
#include <iostream>

using namespace std;

// 배열 요소 값을 서로 바꿔주는 함수
void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int n;
    cin >> n;

    // 배열 생성
    auto *arr = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
        arr[i] = 0;
    }

    // 첫번째 인덱스에 1추가
    arr[1] = 1;

    for (int i = 2; i <= n; ++i) {
        // 2번째 인덱스 부터 2,3,4,5,... 추가
        arr[i] = i;
        // 항상 마지막 리프는 1이어야 하므로
        // 1을 마지막 위치(인덱스)로 변경
        swap(arr[i], arr[i - 1]);

        if (i > 2) {
            // i = 3 일 때 231 -> 321 (2,1)
            // i = 4 일 때 3241 -> 4231 (3,1)
            // i = 5 일 때 42351 -> 45321 -> 54321 (4,2),(2,1)
            // i = 6 일 때 543261 -> 563241 -> 653241 (5,2),(2,1)
            // i = 7 일 때 6532471 -> 6572431 -> 7562431 (6,3),(3,1)
            int j = i - 1;
            while (j != 1) {
                swap(arr[j], arr[j / 2]);
                j /= 2;
            }
        }
    }

    for (int i = 1; i <= n; ++i) {
        cout << arr[i] << " ";
    }

    return 0;
}