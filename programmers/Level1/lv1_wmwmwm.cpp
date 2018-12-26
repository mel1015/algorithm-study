//
// Created by sks10 on 2018-12-26.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    for (int i = 1; i <= n; ++i) {
        if (i % 2 != 0) answer += "수";
        else answer += "박";
    }
    return answer;
}

int main() {
    int n;
    cin >> n;
    cout << solution(n) << endl;
    return 0;
}