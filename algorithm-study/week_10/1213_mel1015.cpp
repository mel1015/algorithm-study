//
// Created by sks10 on 2018-07-02.
//
#include <iostream>

using namespace std;

int main() {
    int t;
    for (int i = 0; i < 10; ++i) {
        cin >> t;
        string str, toFind;
        cin >> toFind;
        cin >> str;

        int count = 0;
        // string::find 함수 사용
        // find 함수는 문자열의 내용을 찾고 위치를 반환
        // 찾는 문자열이 없으면 string::npos를 반환
        // size_t found는 str 문자열에서 toFind 문자열을 찾은 위치
        size_t found = str.find(toFind);
        while (found != string::npos) {
            count++;
            // 찾은 위치의 다음 인덱스부터 다시 검색
            found = str.find(toFind, found + 1);
        }
        cout << "#" << t << " ";
        cout << count << endl;
    }
    return 0;
}
