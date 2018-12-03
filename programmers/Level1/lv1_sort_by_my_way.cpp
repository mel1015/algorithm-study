//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int i;

bool comp(string a, string b) {
    // i(=n)번째 인덱스 값으로 비교 후
    // 같으면 문자열 비교하는 걸 리턴
    // 다르면 인덱스 값으로 비교 리턴
    return a[i] == b[i] ? a < b : a[i] < b[i];
}

vector<string> solution(vector<string> strings, int n) {
    i = n;
    // sort 함수에 비교 함수로 comp 함수 전달
    sort(strings.begin(), strings.end(), comp);
    return strings;
}

int main() {
    int n = 2;
    vector<string> strings = {"abce", "abcd", "cdx"};
    vector<string> answer = solution(strings, n);
    for (string s : answer) {
        cout << s << " ";
    }
    return 0;
}