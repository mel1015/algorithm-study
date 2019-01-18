//
// Created by sks10 on 2019-01-18.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer(heights.size());
    for (int i = heights.size() - 1; i > 0; --i) {
        for (int j = i - 1; j >= 0; --j) {
            if (heights[j] > heights[i]) {
                answer[i] = j + 1;
                break;
            }
        }
    }
    return answer;
}

int main() {
    vector<int> heights = {10, 9, 5, 7, 4};
    vector<int> answer;
    answer = solution(heights);
    for (int i: answer) {
        cout << i << " ";
    }
    return 0;
}