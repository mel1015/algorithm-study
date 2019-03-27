//
// Created by sks10 on 2019-03-27.
//
#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

// 배포 날짜 계산 함수
int GetDate(int a, int b) {
    if ((100 - a) % b == 0) return (100 - a) / b;
    else return (100 - a) / b + 1;
}

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> distributionDate;
    // 큐에 배포 날짜를 넣음
    for (int i = 0; i < progresses.size(); ++i) {
        distributionDate.push(GetDate(progresses[i], speeds[i]));
    }
    // 큐가 빌 때까지
    while (!distributionDate.empty()) {
        // 같은 날짜에 배포되는 기능 개수
        int onSameDate = 0;
        int frontDate = distributionDate.front();
        distributionDate.pop();
        onSameDate++;
        // 큐의 맨 앞의 날짜보다 작으면 같이 배포,
        // 크다면 그 날짜가 다음 배포일의 기준
        while (!distributionDate.empty()) {
            if (distributionDate.front() <= frontDate) {
                distributionDate.pop();
                onSameDate++;
            } else break;
        }
        answer.push_back(onSameDate);
    }
    return answer;
}

int main() {
    vector<int> progresses = {93, 30, 55};
    vector<int> speeds = {1, 30, 5};
    vector<int> answer = solution(progresses, speeds);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}