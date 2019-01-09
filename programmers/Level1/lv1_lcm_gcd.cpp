//
// Created by sks10 on 2019-01-09.
//
#include <iostream>
#include <string>
#include <vector>
#include <numeric>

using namespace std;

int gcd(int a, int b) {
    while (true) {
        if (a == 0) return b;
        b %= a;
        if (b == 0) return a;
        a %= b;
    }
}

int lcm(int a, int b) {
    int temp = gcd(a, b);
    return temp ? (a / temp * b) : 0;
}

vector<int> solution(int n, int m) {
    vector<int> answer;
    answer.push_back(gcd(n, m));
    answer.push_back(lcm(n, m));
    return answer;
}

int main() {
    int n, m;
    vector<int> answer;
    cin >> n >> m;
    answer = solution(n, m);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}