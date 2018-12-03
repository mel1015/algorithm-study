//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    for (int i : arr) {
        if (i % divisor == 0) answer.push_back(i);
    }
    if (answer.empty()) answer.push_back(-1);
    else sort(answer.begin(), answer.end());
    return answer;
}

int main() {
    int divisor = 5;
    vector<int> arr = {5, 9, 7, 10};
    vector<int> answer = solution(arr, divisor);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}