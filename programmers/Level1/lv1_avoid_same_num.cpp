//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int>::iterator it;
    it = unique(arr.begin(), arr.end());
    arr.resize(distance(arr.begin(), it));
    return arr;
}

int main() {
    vector<int> arr = {1, 1, 3, 3, 0, 1, 1};
    vector<int> answer;
    answer = solution(arr);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}
