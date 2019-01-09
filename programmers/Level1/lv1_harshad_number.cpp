//
// Created by sks10 on 2019-01-09.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    bool answer = true;
    int a = x, sum = 0;
    while (a != 0) {
        sum += a % 10;
        a /= 10;
    }
    if (x % sum != 0) answer = false;
    return answer;
}

int main() {
    int n;
    cin >> n;
    cout << solution(n);
    return 0;
}