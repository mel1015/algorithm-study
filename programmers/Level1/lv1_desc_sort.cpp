//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool desc(int a, int b) {
    return a > b;
}

string solution(string s) {
    sort(s.begin(), s.end(), desc);
    return s;
}

int main() {
    string s = "Zbcdefg";
    cout << solution(s);
    return 0;
}