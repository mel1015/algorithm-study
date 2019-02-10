//
// Created by sks10 on 2019-02-01.
//
#include <iostream>
#include <vector>

using namespace std;

vector<int> intToArray(int x) {
    vector<int> resultArray;
    while (true) {
        resultArray.insert(resultArray.begin(), x % 10);
        x /= 10;
        if (x == 0)
            return resultArray;
    }
}

int solution(vector<vector<int>> baseball) {
    int answer = 0;
    vector<int> guess, ans;
    // 완전탐색 방법으로 모든 가능성 체크
    for (int check = 123; check <= 987; ++check) {
        int count = 0;
        guess = intToArray(check);
        // 숫자에 0이 있거나 같은 수 중복이면 스킵
        if (!guess[1] || !guess[2] || guess[0] == guess[1]
            || guess[1] == guess[2] || guess[2] == guess[0])
            continue;
        // 추측하는 숫자와 질문한 숫자 비교
        for (int i = 0; i < baseball.size(); ++i) {
            int strike = 0, ball = 0;
            int call = baseball[i][0];
            ans = intToArray(call);

            for (int j = 0; j < 3; ++j) {
                if (guess[j] == ans[j]) strike++;
                if (guess[j] == ans[(j + 1) % 3]
                    || guess[j] == ans[(j + 2) % 3])
                    ball++;
            }
            // 추축한 숫자가 콜의 조건을 만족하면
            // count 증가
            if (strike == baseball[i][1]
                && ball == baseball[i][2])
                count++;
        }
        // 모든 조건(strike, ball의 개수)이 맞으면
        // 정답 수 증가
        if (count == baseball.size())
            answer++;
    }
    return answer;
}

int main() {
    vector<vector<int>> baseball = {{123, 1, 1},
                                    {356, 1, 0},
                                    {327, 2, 0},
                                    {489, 0, 1}};
    cout << solution(baseball);
    return 0;
}