//
// Created by sks10 on 2019-04-04.
//
#include <iostream>
#include <vector>

using namespace std;

int N, answer = 0;
vector<pair<int, int>> counsel;

void maxProfit(int idx, int profit) {
    // main 함수에서 선택된 상담 일 수와 금액이 넘어옴
    for (int i = idx + counsel[idx].first; i < N; ++i) {
        // 그 다음으로 선택할 수 있는 상담 선택
        if (i + counsel[i].first <= N) {
            maxProfit(i, profit + counsel[i].second);
            // 최댓값 갱신
            answer = max(answer, profit + counsel[i].second);
        }
    }
}

int main() {
    cin >> N;
    counsel.resize(N);
    for (int i = 0; i < N; ++i) {
        cin >> counsel[i].first >> counsel[i].second;
    }
    // 1일부터 그 날의 상담을 수락
    for (int i = 0; i < N; ++i) {
        // 수락한 상담을 퇴사 전까지 끝낼 수 있는지
        if (i + counsel[i].first <= N) {
            maxProfit(i, counsel[i].second);
        }
    }
    // 하나의 상담이 모든 계산보다 클 경우
    for (int i = 0; i < N; ++i) {
        if (i + counsel[i].first <= N) {
            if (answer < counsel[i].second)
                answer = counsel[i].second;
        }
    }
    cout << answer;
    return 0;
}
