//
// Created by sks10 on 2019-01-01.
//
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    while (n != 0) {
        answer += (n % 10);
        n = n / 10;
    }
    return answer;
}

int main() {
    int n;
    cin >> n;
    cout << solution(n);
    return 0;
}