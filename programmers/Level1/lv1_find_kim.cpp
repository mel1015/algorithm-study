//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

string solution(vector<string> seoul) {
    string answer = "";
    vector<string>::iterator it;

    it = find(seoul.begin(), seoul.end(), "Kim");
    answer += "김서방은 " + to_string(distance(seoul.begin(), it))
              + "에 있다";
    return answer;
}

int main() {
    vector<string> seoul = {"Jane", "Kim"};
    cout << solution(seoul);
    return 0;
}