//
// Created by sks10 on 2018-11-29.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<vector<int>> arr(3);
    vector<int> score;
    arr[0] = {1, 2, 3, 4, 5};
    arr[1] = {2, 1, 2, 3, 2, 4, 2, 5};
    arr[2] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    score.assign(3, 0);
    for (int i = 0; i < answers.size(); ++i) {
        if (arr[0][i % 5] == answers[i]) score[0]++;
        if (arr[1][i % 8] == answers[i]) score[1]++;
        if (arr[2][i % 10] == answers[i]) score[2]++;
    }

    int max_score = *max_element(score.begin(), score.end());
    for (int j = 0; j < 3; ++j) {
        if (score[j] == max_score) answer.push_back(j + 1);
    }
    return answer;
}

int main() {
    vector<int> answers = {1, 2, 3, 4, 5};
    vector<int> answer;
    answer = solution(answers);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}