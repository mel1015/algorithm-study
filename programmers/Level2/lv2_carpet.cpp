//
// Created by sks10 on 2019-02-11.
//
#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
    int x, y, count = 0;
    // 빨간색 격자로 만들 수 있는
    // 직사각형들의 가로 세로를 구하고
    // 갈색 격자의 개수 구함
    for (int i = sqrt(red); i >= 1; --i) {
        if (red % i == 0) {
            x = red / i, y = i;
            count = (x * 2) + (y * 2) + 4;
            if (count == brown) {
                answer.push_back(x + 2);
                answer.push_back(y + 2);
                break;
            }
        }
    }
    return answer;
}

int main() {
    int brown, red;
    cin >> brown >> red;
    vector<int> answer = solution(brown, red);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}