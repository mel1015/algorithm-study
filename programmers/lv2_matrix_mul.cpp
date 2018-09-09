//
// Created by sks10 on 2018-09-09.
//
#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    answer.resize(arr1.size());
    for (int i = 0; i < arr1.size(); ++i) {
        answer[i].resize(arr2[0].size());
    }

    for (int arr1Row = 0; arr1Row < arr1.size(); ++arr1Row) {
        for (int arr2Col = 0; arr2Col < arr2[0].size(); ++arr2Col) {
            for (int i = 0; i < arr1[arr1Row].size(); ++i) {
                answer[arr1Row][arr2Col] += arr1[arr1Row][i] * arr2[i][arr2Col];
            }
        }
    }
    return answer;
}

int main() {
    vector<vector<int>> arr1 = {{2, 3, 2},
                                {4, 2, 4},
                                {3, 1, 4}};
    vector<vector<int>> arr2 = {{5, 4, 3},
                                {2, 4, 1},
                                {3, 1, 1}};

    vector<vector<int>> answer = solution(arr1, arr2);
    for (int i = 0; i < answer.size(); ++i) {
        for (int j = 0; j < answer[0].size(); ++j) {
            cout << answer[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}