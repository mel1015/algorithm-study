//
// Created by sks10 on 2018-09-22.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> healths, vector<vector<int>> items) {
    vector<int> answer;
    sort(healths.begin(), healths.end());
    for (int i = 0; i < healths.size(); ++i) {
        for (int j = 0; j < items.size(); ++j) {
            if (items[j][1] > 0 && (healths[i] - items[j][1]) >= 100) {
                answer.push_back(j + 1);
                items[j][1] = -1;
                break;
            }
        }
    }
    sort(answer.begin(), answer.end());
    return answer;
}


int main() {
    vector<int> healths = {300, 200, 500};
    vector<vector<int>> items = {{1000, 600},
                                 {400,  500},
                                 {300,  100}};
    vector<int> answer = solution(healths, items);
    for (int i = 0; i < answer.size(); ++i) {
        cout << answer[i] << " ";
    }
    return 0;
}