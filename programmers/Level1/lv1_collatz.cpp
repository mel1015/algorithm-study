//
// Created by sks10 on 2019-01-09.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int answer = 0;
    long n = num;
    while (n != 1) {
        if (answer > 500) return -1;
        if (n % 2 == 0) n /= 2;
        else n = (n * 3) + 1;
        answer++;
    }
    return answer;
}

int main() {
    int n;
    cin >> n;
    cout << solution(n);
    return 0;
}