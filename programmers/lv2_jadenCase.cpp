//
// Created by sks10 on 2018-09-09.
//
#include <iostream>
#include <sstream>

using namespace std;

string solution(string s) {
    // 첫번째 문자 대문자로
    s.at(0) = toupper(s.at(0));
    for (int i = 1; i < s.length(); i++) {
        // 이전 문자가 공백이면 단어가 시작한다고 판단
        // 따라서 " " + 문자 이면 대문자로, 아니면 소문자로
        s.at(i) = (s.at(i - 1) == ' ') ? toupper(s.at(i)) : tolower(s.at(i));
    }
    return s;
}

int main() {
    string s("3people    AnD 2PeoPle unFollowed mEEEEE");
    cout << solution(s);
    return 0;
}