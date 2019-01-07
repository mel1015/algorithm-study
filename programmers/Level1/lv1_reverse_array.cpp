//
// Created by sks10 on 2019-01-07.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(long long n) {
    vector<int> answer;
    while (n != 0) {
        answer.push_back(n % 10);
        n /= 10;
    }
    return answer;
}

int main() {
    long long n;
    vector<int> answer;
    cin >> n;
    answer = solution(n);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}