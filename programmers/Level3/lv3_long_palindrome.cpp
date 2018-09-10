//
// Created by sks10 on 2018-09-10.
//
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0;
    int length = s.length();

    // 문자열의 시작 위치 i
    for (int i = 0; i < length; i++) {
        // 부분 문자열의 길이 subLength
        // subLength 가 answer보다 클때만
        // 가장 긴 부분 문자열이 나왔으면 검사할 필요 X
        for (int subLength = length; subLength > answer; subLength--) {
            int left = i;
            int right = left + subLength - 1;
            while (left < right && s[left] == s[right]) {
                left++;
                right--;
            }
            if (left >= right && answer < subLength) {
                answer = subLength;
                break;
            }
        }
    }
    return answer;
}

int main() {
    string s = "abcdcba";
    cout << solution(s) << endl;
    string k = "abacde";
    cout << solution(k) << endl;
    return 0;
}
