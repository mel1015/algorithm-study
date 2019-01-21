//
// Created by sks10 on 2019-01-21.
//
#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<pair<int, int>> printer;

    for (int i = 0; i < priorities.size(); ++i) {
        printer.push(make_pair(i, priorities[i]));
    }
    while (true) {
        int top_priority =
                *max_element(priorities.begin(), priorities.end());
        pair<int, int> front = printer.front();
        if (front.second == top_priority) {
            printer.pop();
            answer++;
            *max_element(priorities.begin(), priorities.end()) = 0;
            if (front.first == location) {
                return answer;
            }
        } else {
            printer.pop();
            printer.push(front);
        }
    }
}

int main() {
    vector<int> priorities = {1, 1, 9, 1, 1, 1};
    int location = 0;
    cout << solution(priorities, location);
    return 0;
}