//
// Created by sks10 on 2019-01-10.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer;
    for (int i = 1; i <= n; ++i) {
        answer.push_back(x * i);
    }
    return answer;
}

int main() {
    int x, n;
    cin >> x >> n;
    vector<long long> answer;
    answer = solution(x, n);
    for (long long int & i : answer) {
        cout << i << " ";
    }
    return 0;
}