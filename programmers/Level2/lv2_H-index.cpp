//
// Created by sks10 on 2019-02-01.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    sort(citations.begin(), citations.end(), greater<int>());
    for (int i = 0; i < citations.size(); ++i) {
        if (citations[i] > i) answer++;
        else break;
    }
    return answer;
}

int main() {
    vector<int> citations = {3, 0, 6, 1, 5};
    cout << solution(citations);
    return 0;
}