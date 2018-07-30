//
// Created by sks10 on 2018-07-30.
//
#include <iostream>

using namespace std;

int fee[4], use_Days[12];

int get_Low_Fee() {
    int money[13] = {0,};
    for (int i = 1; i <= 12; ++i) {
        // 이전 달의 사용료를 누적
        // 1일 이용권과 1달 이용권 중 적은 비용을 택
        money[i] = min(money[i - 1] + (fee[0] * use_Days[i - 1]), money[i - 1] + fee[1]);
        if (i >= 3) {
            // 3월 부터는 현재까지의 누적 비용과 3달 이용권 중 적은 비용을 택
            money[i] = min(money[i], money[i - 3] + fee[2]);
        }
    }
    // 최종 누적 비용 리턴
    return money[12];
}

int main() {
    int testCase, ans;
    cin >> testCase;

    for (int tc = 1; tc <= testCase; ++tc) {
        // 비용 입력
        for (int &i : fee) {
            cin >> i;
        }
        // 사용일 수 입력
        for (int &use_Day : use_Days) {
            cin >> use_Day;
        }
        ans = get_Low_Fee();
        // 최종 계산 비용과 1년 비용과 비교
        ans = min(ans, fee[3]);
        cout << "#" << tc << " " << ans << "\n";
    }
    return 0;
}
