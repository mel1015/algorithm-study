//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    if (a > b) {
        int temp = a;
        a = b;
        b = temp;
    }
    for (int i = a; i <= b; ++i) {
        answer += i;
    }
    return answer;
}

int main() {
    int a, b;
    cin >> a >> b;
    cout << solution(a, b);
    return 0;
}