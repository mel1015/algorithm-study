//
// Created by sks10 on 2018-07-07.
//
#include <iostream>
#include <vector>

using namespace std;

vector<int> scores;

int main() {
    int testCase, testNum, data;
    cin >> testCase;

    for (int i = 1; i <= testCase; ++i) {
        cin >> testNum;
        scores.resize(101);

        for (int j = 0; j < 1000; ++j) {
            cin >> data;
            scores[data]++;
        }
        // 최빈수가 여러개일 때
        int temp = 0, maxValue = 0;
        for (int k = 0; k <= 100; ++k) {
            if (scores[k] >= temp) {
                temp = scores[k];
                maxValue = k;
            }
        }
        cout << "#" << testNum << " " << maxValue << "\n";
        scores.clear();
    }
    return 0;
}