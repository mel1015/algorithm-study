//
// Created by sks10 on 2018-09-22.
//
#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

bool built[101][101];

int solution(int N, vector<vector<int>> house) {
    double answer = 0, distance = 0, min_distance = 20000;
    for (int i = 0; i < house.size(); ++i) {
        distance = pow(100 - abs(house[i][0]), 2.0) + pow(100 - abs(house[i][1]), 2.0);
        if (distance < min_distance) {
            min_distance = distance;
        }
    }
    answer = min_distance;
    return (int) answer;
}

int main() {
    int N = 3;
    vector<vector<int>> house = {{0,  0},
                                 {1,  0},
                                 {10, 1},
                                 {2,  9}};
    cout << solution(N, house);
    return 0;
}