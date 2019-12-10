//
// Created by sks10 on 2019-04-03.
//
#include <iostream>
#include <vector>

using namespace std;

long long solution(vector<int> room, int B, int C) {
    long long sum = 0;
    for (int i = 0; i < room.size(); ++i) {
        // 총 감독관으로 감시 할 수 있는 인원 감소
        int canOversee = room[i] - B;
        sum++;
        if (canOversee <= 0) {
            // 총 감독관 1명으로 가능 하므로
            continue;
        } else {
            // 부 감독관이 감독할 수 있는 인원
            sum += (canOversee % C == 0) ?
                   canOversee / C : (canOversee / C) + 1;
        }
    }
    return sum;
}

int main() {
    int N, B, C;
    vector<int> room;
    cin >> N;
    room.resize(N);
    for (int i = 0; i < N; ++i) {
        int a;
        cin >> a;
        room[i] = a;
    }
    cin >> B >> C;
    cout << solution(room, B, C) << endl;
    return 0;
}