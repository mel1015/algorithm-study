//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = true;
    if (s.length() != 4 && s.length() != 6) return false;
    for (char i : s) {
        if (isalpha(i)) return false;
    }
    return answer;
}

int main() {
    string s = "a234";
    cout << solution(s);
    return 0;
}