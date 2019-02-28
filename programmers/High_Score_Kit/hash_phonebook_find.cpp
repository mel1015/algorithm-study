//
// Created by sks10 on 2019-02-28.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    // 정렬로 작은 문자열부터 => 길이 상관 없음
    sort(phone_book.begin(), phone_book.end());

    // 현재 번호와 그 다음 모든 번호들 비교
    for (int i = 0; i < phone_book.size(); ++i) {
        for (int j = i + 1; j < phone_book.size(); ++j) {
            // string::find => 찾는 문자열이 해당 문자열의
            // 몇번째 위치에있는지 리턴
            // 따라서, 0에 있으면 접두어
            size_t found = phone_book[j].find(phone_book[i]);
            if (found == 0) {
                return false;
            }
        }
    }
    return answer;
}

int main() {
    vector<string> phone_book = {"119", "1234", "119440", "12345", "98346"};
    cout << solution(phone_book);
    return 0;
}