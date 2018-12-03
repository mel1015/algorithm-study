//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int length = s.length();
    if (length % 2 != 0) {
        answer = s[length / 2];
    } else {
        answer += s[length / 2 - 1];
        answer += s[length / 2];
    }
    return answer;
}

int main() {
    string s;
    cin >> s;
    cout << solution(s);
    return 0;
}