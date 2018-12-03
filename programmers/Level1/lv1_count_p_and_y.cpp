//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <string>

using namespace std;

bool solution(string s) {
    bool answer = true;
    int count_p = 0, count_y = 0;
    for (int i = 0; i < s.length(); ++i) {
        if (s[i] == 'p' || s[i] == 'P') count_p++;
        if (s[i] == 'y' || s[i] == 'Y') count_y++;
    }
    if (count_p != count_y) answer = false;
    return answer;
}

int main() {
    string s = "pPoooyY";
    cout << solution(s);
    return 0;
}