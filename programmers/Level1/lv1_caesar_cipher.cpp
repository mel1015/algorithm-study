//
// Created by sks10 on 2018-12-26.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string s, int n) {
    string answer = "";
    int string_length = s.length();
    for (int i = 0; i < string_length; ++i) {
        if (s[i] == ' ') {
            answer += " ";
            continue;
        }
        cout << s[i] << " >> ";
        if (isupper(s[i]) && s[i] > 90 - n) s[i] -= 26;
        else if (islower(s[i]) && s[i] > 122 - n) s[i] -= 26;
        s[i] += n;
        cout << s[i] << endl;
        answer += s[i];
    }
    return answer;
}

int main() {
    string s = "a B z";
    int n = 4;
    cout << solution(s, n);
    return 0;
}