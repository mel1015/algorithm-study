//
// Created by sks10 on 2018-07-18.
//
#include <iostream>
#include <vector>

using namespace std;

#define arrSize 100

vector<vector<char>> arr;

// x, y = 좌표, dir = 방향
int is_Palindrome(int x, int y, int dir) {
    int odd_size = 1, even_size = 0;

    // dir = 0 이면 가로
    // dir = 1 이면 세로
    if (!dir) {
        // 짝수일 때
        // i, i+1 비교 >>> i-1, i+2 비교 >>> i-2, i+3 비교
        for (int i = 0; i < arrSize / 2; ++i) {
            if (y - i < 0 || y + i + 1 >= arrSize) break;
            if (arr[x][y - i] == arr[x][y + i + 1]) {
                even_size += 2;
            } else break;
        }
        // 홀수일 때
        // i-1, i+1 비교 >>> i-2, i+2 비교 >>> i-3, i+3 비교
        for (int j = 1; j < arrSize / 2; ++j) {
            if (y - j < 0 || y + j >= arrSize) break;
            if (arr[x][y - j] == arr[x][y + j]) {
                odd_size += 2;
            } else break;
        }
    } else {
        // 짝수일 때
        // i, i+1 비교 >>> i-1, i+2 비교 >>> i-2, i+3 비교
        for (int i = 0; i < arrSize / 2; ++i) {
            if (x - i < 0 || x + i + 1 >= arrSize) break;
            if (arr[x - i][y] == arr[x + i + 1][y]) {
                even_size += 2;
            } else break;
        }
        // 홀수일 때
        // i-1, i+1 비교 >>> i-2, i+2 비교 >>> i-3, i+3 비교
        for (int j = 1; j < arrSize / 2; ++j) {
            if (x - j < 0 || x + j >= arrSize) break;
            if (arr[x - j][y] == arr[x + j][y]) {
                odd_size += 2;
            } else break;
        }
    }
    return max(even_size, odd_size);
}

int main() {
    int testCase;
    for (int tc = 1; tc <= 10; ++tc) {
        cin >> testCase;
        // 배열 생성
        arr.resize(arrSize);
        for (int i = 0; i < arrSize; ++i) {
            arr[i].resize(arrSize);
        }
        // 데이터 입력
        for (int i = 0; i < arrSize; ++i) {
            for (int j = 0; j < arrSize; ++j) {
                cin >> arr[i][j];
            }
        }
        // 결과 중 큰 것 저장
        int result = 0;
        for (int i = 0; i < arrSize; ++i) {
            for (int j = 0; j < arrSize; ++j) {
                result = max(result, is_Palindrome(i, j, 0));
                result = max(result, is_Palindrome(i, j, 1));
            }
        }
        cout << "#" << testCase << " " << result << "\n";
        arr.clear();
    }
    return 0;
}