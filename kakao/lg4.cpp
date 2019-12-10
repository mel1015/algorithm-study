//
// Created by sks10 on 2018-09-22.
//
#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(int N, vector<vector<int>> directory, vector<vector<int>> query) {
    vector<int> answer;
    int count = 0;
    for (int i = 0; i < query.size(); ++i) {

    }
    return answer;
}

int main() {
    int N = 5;
    vector<vector<int>> directory = {{1, 2},
                                     {1, 3},
                                     {2, 4},
                                     {2, 5}};
    vector<vector<int>> query = {{1, 5},
                                 {2, 5},
                                 {3, 5},
                                 {4, 5}};
    vector<int> answer = solution(N, directory, query);
    for (int i = 0; i < answer.size(); ++i) {
        cout << answer[i] << " ";
    }
    return 0;
}