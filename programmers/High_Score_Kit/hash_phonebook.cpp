//
// Created by sks10 on 2018-09-14.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    // 정렬
    sort(phone_book.begin(), phone_book.end());
    for (int i = 1; i < phone_book.size(); ++i) {
        // 접두어와 접두어의 길이만큼의 부분문자열 비교
        if (phone_book[0] == phone_book[i].substr(0, phone_book[0].size())) {
            answer = false;
            break;
        }
    }
    return answer;
}

int main() {
    vector<string> phone_book = {"113", "12340", "123440", "12345", "98346"};
    cout << solution(phone_book);
    return 0;
}