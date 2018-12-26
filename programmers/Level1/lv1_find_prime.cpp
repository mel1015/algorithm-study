//
// Created by sks10 on 2018-12-09.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<int> arr(n + 1);

    // 2부터 n까지 배열 초기화
    for (int i = 2; i <= n; ++i) {
        arr[i] = i;
    }

    for (int i = 2; i <= n; ++i) {
        // 배열의 값이 0이면 소수가 아님
        if (arr[i] == 0) continue;
        else answer++;
        // 2 => 4, 6, 8 ,10 을 0으로
        // 3 => 6, 9 를 0으로
        // 자신의 배수를 0으로 체크하여 소수 판별 안하도록
        for (int j = i + i; j <= n; j += i) {
            arr[j] = 0;
        }
    }
    return answer;
}

int main() {
    int n;
    cin >> n;
    cout << solution(n);
    return 0;
}