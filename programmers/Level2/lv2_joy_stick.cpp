//
// Created by sks10 on 2019-01-22.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int count_Alphabet(char a) {
    if (a > 'M') {
        return 'Z' - a + 1;
    } else {
        return a - 'A';
    }
}

int solution(string name) {
    int answer = 0;
    string str = "";
    for (int j = 0; j < name.length(); ++j) {
        str += "A";
    }
    if (name == str) return answer;

    answer += count_Alphabet(name[0]);
    str[0] = name[0];
    for (int i = 1; i < name.length(); ++i) {
        if (name == str) break;
        answer++;
        answer += count_Alphabet(name[i]);
        str[i] = name[i];
    }

    int answer2 = 0;
    string str2 = "";
    for (int j = 0; j < name.length(); ++j) {
        str2 += "A";
    }
    if (name == str2) return answer2;

    answer2 += count_Alphabet(name[0]);
    str2[0] = name[0];
    for (int i = name.length() - 1; i > 0; --i) {
        if (name == str2) break;
        answer2++;
        answer2 += count_Alphabet(name[i]);
        str2[i] = name[i];
    }
    return min(answer, answer2);
}

int main() {
    string name = "AAAAAB";
    cout << solution(name);
    return 0;
}