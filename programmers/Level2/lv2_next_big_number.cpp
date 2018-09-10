//
// Created by sks10 on 2018-09-07.
//
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0, count = 0, num = n;

    // 주어진 숫자를 2진수 변환 시 1의 개수
    while (n > 0) {
        int digit = n % 2;
        if (digit == 1) count++;
        n /= 2;
    }

    // n의 다음 큰 숫자부터 1의 개수 구하기
    for (int i = 1 + num;; ++i) {
        int temp = 0, newNum = i;
        while (newNum > 0) {
            int digit = newNum % 2;
            if (digit == 1) {
                temp++;
                if (temp > count) break;
            }
            newNum /= 2;
        }
        if (temp == count) {
            answer = i;
            break;
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