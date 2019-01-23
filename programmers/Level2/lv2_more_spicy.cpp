//
// Created by sks10 on 2019-01-23.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 0; i < scoville.size(); ++i) {
        pq.push(scoville[i]);
    }
    while (!pq.empty()) {
        if (pq.top() >= K) break;
        else if (pq.size() == 1 && pq.top() < K) return -1;
        int lowest_scoville, second_lscoville;
        lowest_scoville = pq.top();
        pq.pop();
        second_lscoville = pq.top();
        pq.pop();
        pq.push(lowest_scoville + (second_lscoville * 2));
        answer++;
    }

    return answer;
}

int main() {
    vector<int> scoville = {1, 2, 3, 9, 10, 12};
    int K = 500;
    cout << solution(scoville, K);
    return 0;
}