//
// Created by sks10 on 2019-01-09.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(int num) {
    string answer = "";
    if (num % 2 == 0) answer += "Even";
    else answer += "Odd";
    return answer;
}

int main() {
    int num;
    cin >> num;
    cout << solution(num);
    return 0;
}