//
// Created by sks10 on 2019-01-22.
//
#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    for (int i = 0; i < prices.size(); ++i) {
        int count = 0;
        for (int j = i; j < prices.size() - 1; ++j) {
            if (prices[i] <= prices[j]) count++;
            else break;
        }
        answer.push_back(count);
    }
    return answer;
}

int main() {
    vector<int> prices = {466, 498, 477, 501, 470, 489};
    vector<int> answer;
    answer = solution(prices);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}