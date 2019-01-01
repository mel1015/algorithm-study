//
// Created by sks10 on 2018-12-26.
//
#include <iostream>
#include <sstream>
#include <string>

using namespace std;

string solution(string s) {
    int word_length = 0;
    for (int i = 0; i <= s.length(); ++i) {
        if (s[i] == ' ' || i == s.length()) {
            for (int j = 0; j < word_length; ++j) {
                // index 놀이
                if (j % 2 == 0) s[i + j - word_length] = char(toupper(s[i + j - word_length]));
                else s[i + j - word_length] = char(tolower(s[i + j - word_length]));
            }
            word_length = 0;
        } else word_length++;
    }
    return s;
}

int main() {
    string s = "try hello world";
    cout << solution(s);
    return 0;
}