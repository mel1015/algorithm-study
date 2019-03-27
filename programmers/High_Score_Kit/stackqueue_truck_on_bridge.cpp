//
// Created by sks10 on 2019-03-26.
//
#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0, onBridgeWeight = 0, index=0;
    queue<int> bridge;
    // 트럭은 순서대로 다리에 올라감
    // 올라감과 동시에 시간과 무게 추가
    bridge.push(truck_weights[index]);
    onBridgeWeight += truck_weights[index++];
    answer++;
    // 마지막 트럭이 다리에 올라갈 때까지만
    while (index < truck_weights.size()) {
        // 다리가 가득 찼을 때
        // 맨 앞에 있는 트럭을 빼내고 무게 감소
        if (bridge.size() == bridge_length) {
            onBridgeWeight -= bridge.front();
            bridge.pop();
        }
        // 다음 트럭도 다리에 올라갈 수 있을 때
        if (onBridgeWeight + truck_weights[index] <= weight) {
            bridge.push(truck_weights[index]);
            onBridgeWeight += truck_weights[index++];
            answer++;
        } else {
            // 무게 초과 시에 0을 넣어서
            // 다리를 채우고, 시간 증가
            bridge.push(0);
            answer++;
        }
    }
    // 마지막으로 들어간 트럭은 다리 길이 만큼
    // 이동해야 하므로 다리 길이를 더해줌
    return answer + bridge_length;
}

int main() {
    int bridge_length = 100, weight = 100;
    vector<int> truck_weights = {10, 10, 10, 10, 10,
                                 10, 10, 10, 10, 10};
//    int bridge_length = 2, weight = 10;
//    vector<int> truck_weights = {7, 4, 5, 6};
    cout << solution(bridge_length, weight, truck_weights);
    return 0;
}