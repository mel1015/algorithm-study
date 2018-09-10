//
// Created by sks10 on 2018-09-07.
//
#include <iostream>

using namespace std;

string solution(int n) {
    string answer = "";
    char numbers[3] = {'1', '2', '4'};
    int quotient = -1, remainder;

    while (quotient != 0) {
        quotient = (n - 1) / 3;
        remainder = (n - 1) % 3;
        answer = numbers[remainder] + answer;
        // answer = "124"[remainder] + answer;
        // "124" -> 문자열 = 문자배열 이므로 위의 numbers 배열이 필요없어짐
        n = quotient;
    }
    return answer;
}

int main() {
    int n;

    cin >> n;
    cout << solution(n);

    return 0;
}
