//
// Created by sks10 on 2019-01-09.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    vector<int>::iterator it;
    it = min_element(arr.begin(), arr.end());
    arr.erase(it);
    if (arr.empty()) answer.push_back(-1);
    else answer = arr;
    return answer;
}

int main() {
    vector<int> arr = {4,3,2,1};
    vector<int> answer;
    answer = solution(arr);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}