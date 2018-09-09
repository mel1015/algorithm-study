//
// Created by sks10 on 2018-09-08.
//
#include <iostream>
#include <vector>

using namespace std;

int solution(vector<vector<int> > land) {
    int answer = 0, size = land.size();
    for (int i = 1; i < size; ++i) {
        for (int j = 0; j < 4; ++j, answer = 0) {
            for (int k = 0; k < 4; ++k) {
                // 같은 열 스킵
                if (j == k) continue;
                // 윗 행의 최대 값
                answer = (answer > land[i - 1][k]) ? answer : land[i - 1][k];
            }
            land[i][j] += answer;
        }
    }
    for (int i = 0; i < 4; ++i) {
        answer = (answer > land[size - 1][i]) ? answer : land[size - 1][i];
    }
    return answer;
}

int main() {
    int n;
    vector<vector<int> > land;

    cin >> n;
    land.resize(n);
    for (int i = 0; i < n; ++i) {
        land[i].resize(4);
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < 4; ++j) {
            cin >> land[i][j];
        }
    }
    cout << solution(land);

    return 0;
}