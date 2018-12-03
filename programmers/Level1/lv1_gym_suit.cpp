//
// Created by sks10 on 2018-12-01.
//
#include <iostream>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    vector<int> gymSuit;
    gymSuit.assign(n + 1, 1);
    for (int i : reserve) {
        gymSuit[i]++;
    }
    for (int i : lost) {
        gymSuit[i]--;
    }
    for (int i = 1; i <= n; ++i) {
        if (gymSuit[i] == 2) {
            if (gymSuit[i - 1] == 0)
                gymSuit[i - 1]++, gymSuit[i]--;
            if (i + 1 < n && gymSuit[i + 1] == 0)
                gymSuit[i + 1]++, gymSuit[i]--;
        }
    }
    for (int i = 1; i <= n; ++i) {
        if (gymSuit[i] > 0) answer++;
    }
    return answer;
}

int main() {
    int n = 5;
    vector<int> lost = {2, 4};
    vector<int> reserve = {1, 3, 5};
    cout << solution(n, lost, reserve);
    return 0;
}