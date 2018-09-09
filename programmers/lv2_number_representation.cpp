//
// Created by sks10 on 2018-09-09.
//
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;

    for (int i = n; i > 0; --i) {
        int sum = 0;
        for (int j = i; j > 0; --j) {
            sum += j;
            if (sum == n) {
                answer++;
                break;
            } else if (sum > n) break;
        }
    }

    return answer;
}

int main() {
    int n;

    cin >> n;
    cout << solution(n);

    return 0;
}