//
// Created by sks10 on 2019-02-11.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int solution(int stock, vector<int> dates,
             vector<int> supplies, int k) {
    int answer = 0;
    priority_queue<int> pq;
    int index = 0;
    // stock = 공장 운용 가능일 수
    // 우선순위 큐를 사용
    // stock이 k보다 작으면 운용 가능한 날 내에서
    // 가장 큰 값(pq.top())을 stock에 더함
    while (stock < k) {
        for (int i = index; i < dates.size(); ++i) {
            if (dates[i] <= stock) {
                pq.push(supplies[i]);
            } else {
                index = i;
                break;
            }
        }
        answer++;
        stock += pq.top();
        pq.pop();
    }
    return answer;
}

int main() {
    int stock = 4, k = 30;
    vector<int> dates = {4, 10, 15};
    vector<int> supplies = {20, 5, 10};
    cout << solution(stock, dates, supplies, k);
    return 0;
}