//
// Created by sks10 on 2019-01-09.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1,
                             vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    answer.resize(arr1.size());
    for (int i = 0; i < arr1.size(); ++i) {
        answer[i].resize(arr1[i].size());
    }
    for (int i = 0; i < arr1.size(); ++i) {
        for (int j = 0; j < arr1[i].size(); ++j) {
            answer[i][j] = arr1[i][j] + arr2[i][j];
        }
    }
    return answer;
}

int main() {
    vector<vector<int>> arr1 = {{1, 2},
                                {2, 3}};
    vector<vector<int>> arr2 = {{3, 4},
                                {5, 6}};
    vector<vector<int>> answer = solution(arr1, arr2);
    for (int i = 0; i < answer.size(); ++i) {
        for (int j = 0; j < answer[i].size(); ++j) {
            cout << answer[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}