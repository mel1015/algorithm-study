//
// Created by sks10 on 2018-09-09.
//
#include <iostream>
#include <vector>
#include <sstream>
#include <regex>

using namespace std;

string solution(string s) {
    string answer = "";
    int minVal = INT32_MAX, maxVal = INT32_MIN;

    // string split 참고 사이트
    // https://www.fluentcpp.com/2017/04/21/how-to-split-a-string-in-c/
    istringstream iss(s);
    vector<string> words(istream_iterator<string>{iss},
                         istream_iterator<string>());

    for (const auto &word : words) {
        int n = stoi(word);
        minVal = min(minVal, n);
        maxVal = max(maxVal, n);
    }
    answer += to_string(minVal) + " " + to_string(maxVal);
    return answer;
}

int main() {
    string s("0 -1 100 -14");
    cout << solution(s);

    return 0;
}