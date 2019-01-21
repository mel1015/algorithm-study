//
// Created by sks10 on 2019-01-21.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string arrangement) {
    int answer = 0, count_left = 0;
    for (int i = 0; i < arrangement.length(); ++i) {
        if (arrangement[i] == '(') count_left++;
        else {
            count_left--;
            if (arrangement[i - 1] == '(')
                answer += count_left;
            else answer++;
        }
    }
    return answer;
}

int main() {
    string arrangement = {"()(((()())(())()))(())"};
    cout << solution(arrangement);
    return 0;
}