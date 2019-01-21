//
// Created by sks10 on 2019-01-19.
//
#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight,
             vector<int> truck_weights) {
    queue<int> bridge;
    int sum = 0, time = 0;
    // 모든 트럭이 정해진 순으로
    for (int i = 0; i < truck_weights.size(); i++) {
        int truck = truck_weights[i];
        while (true) {
            if (bridge.empty()) {
                // 다리(큐)가 비었을 시
                bridge.push(truck);
                time++;
                sum += truck;
                break;
            } else if (bridge.size() == bridge_length) {
                // 다리가 가득 찼을 때
                sum -= bridge.front();
                bridge.pop();
            } else {
                if (sum + truck > weight) {
                    // 다리의 최대 무게를 넘으면
                    // 현재 트럭이 다리를 다 건너야 하므로
                    // 0을 push하고 시간 카운트
                    bridge.push(0);
                    time++;
                } else {
                    // 트럭이 추가로 더 건널 수 있을 때
                    bridge.push(truck);
                    time++;
                    sum += truck;
                    break;
                }
            }
        }
    }
    return time + bridge_length;
}

int main() {
    int bridge_length = 100;
    int weight = 100;
    vector<int> truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    cout << solution(bridge_length, weight, truck_weights);
    return 0;
}