//
// Created by sks10 on 2019-03-27.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    answer.resize(heights.size());
    // 맨 오른쪽 탑부터 왼쪽으로 신호를 쏨
    for (int i = heights.size() - 1; i >= 0; --i) {
        for (int j = i - 1; j >= 0; --j) {
            // 자신보다 왼쪽에 있는 탑이
            // 자신의 높이보다 높으면 신호 수신
            if (heights[i] < heights[j]) {
                answer[i] = j + 1;
                break;
            }
        }
    }
    return answer;
}

int main() {
    vector<int> heights = {6, 9, 5, 7, 4};
    vector<int> answer = solution(heights);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}