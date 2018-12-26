//
// Created by sks10 on 2018-12-26.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    answer = stoi(s);
    return answer;
}

int main() {
    string s = "-1234";
    cout << solution(s);
    return 0;
}