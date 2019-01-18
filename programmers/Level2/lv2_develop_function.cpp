//
// Created by sks10 on 2019-01-18.
//
#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> complete;

    for (int i = 0; i < progresses.size(); ++i) {
        int to_do = (100 - progresses[i]) / speeds[i];
        if ((100 - progresses[i]) % speeds[i] == 0) {
            complete.push_back(to_do);
        } else {
            complete.push_back(to_do + 1);
        }
    }


    for (int i = 0; i < complete.size(); ++i) {
        int front = complete[i];
        int count = 1;
        if (i == complete.size() - 1) answer.push_back(count);
        for (int j = i + 1; j < complete.size(); ++j) {
            int next = complete[j];
            if (front >= next) {
                count++;
                i++;
                if (i == complete.size() - 1) answer.push_back(count);
            } else {
                answer.push_back(count);
                break;
            }
        }
    }
    return answer;
}

int main() {
    vector<int> progresses = {98, 0, 55, 80};
    vector<int> speeds = {1, 10, 5, 4};
    vector<int> answer;
    answer = solution(progresses, speeds);
    for (int i:answer) {
        cout << i << " ";
    }
    return 0;
}