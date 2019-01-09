//
// Created by sks10 on 2019-01-09.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

double solution(vector<int> arr) {
    double answer = 0;
    int sum = 0;
    for (int i : arr) {
        sum += i;
    }
    answer = (double)sum / arr.size();
    return answer;
}

int main() {
    vector<int> arr = {1, 2, 3, 4};
    cout << solution(arr);
    return 0;
}