//
// Created by sks10 on 2019-03-26.
//
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 1;
    queue<pair<int, int>> printer;
    // 큐에 중요도와 위치를 담은 pair 넣음
    for (int i = 0; i < priorities.size(); ++i) {
        printer.push(make_pair(priorities[i], i));
    }
    // 중요도 순으로 큐에서 빼내기 위해 내림차순 정렬
    sort(priorities.begin(), priorities.end(), greater<int>());
    // 중요도 순서를 저장하는 변수
    int index = 0;
    while (true) {
        // 큐의 가장 앞에 있는 값
        pair<int, int> current = printer.front();
        if (current.first != priorities[index]) {
            // 중요도가 첫번째가 아니면
            // 큐에서 빼내고 맨뒤로 보냄
            printer.pop();
            printer.push(current);
        } else if (current.second == location) {
            // 출력할 문서이면 반복문 탈출
            break;
        } else {
            // 중요도가 높은게 큐의 맨 앞이면
            // 중요도 배열 인덱스 증가
            // 큐에서 빼내고 인쇄 순서 증가
            index++;
            printer.pop();
            answer++;
        }
    }
    return answer;
}

int main() {
    vector<int> priorities = {2,1,3,2};
    int location = 2;
    cout << solution(priorities, location);
    return 0;
}
