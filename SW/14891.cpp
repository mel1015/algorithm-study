//
// Created by sks10 on 2019-04-08.
//
#include <iostream>
#include <vector>
#include <deque>

using namespace std;

// 4개의 톱니바퀴
// 12시부터 시계방향으로 8방향의 톱니
vector<deque<int>> gear(5);
vector<bool> visited(5);
int K, answer = 0;

void rotate(int num, int dir) {
    // 현재의 톱니바퀴가 회전
    visited[num] = true;
    int left = num - 1, right = num + 1;
    // 현재가 시계 방향 => 왼쪽, 오른쪽 모두 반시계 방향
    // 현재가 반시계 방향 => 왼쪽, 오른쪽 모두 시계 방향
    // 현재 방향(dir)의 반대방향으로 돌아감
    // 오른쪽 톱니의 index = 2, 왼쪽의 톱니 index = 6
    if (left > 0 && gear[left][2] != gear[num][6] && !visited[left]) {
        // 왼쪽 톱니바퀴 회전
        rotate(left, dir * -1);
    }
    if (right <= 4 && gear[right][6] != gear[num][2] && !visited[right]) {
        // 오른쪽 톱니바퀴 회전
        rotate(right, dir * -1);
    }
    if (dir == 1) {
        // 시계방향
        // 맨 뒤의 값을 맨 앞으로
        int backNum = gear[num].back();
        gear[num].pop_back();
        gear[num].push_front(backNum);
    } else {
        // 반시계 방향
        // 맨 앞의 값을 맨 뒤로
        int frontNum = gear[num].front();
        gear[num].pop_front();
        gear[num].push_back(frontNum);
    }
    // 자신의 회전으로 발생한 모든 회전들 마무리하고
    // 그 후 자신이 다른 톱니바퀴에 의해 회전을 할 수 있으므로
    visited[num] = false;
}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    // string으로 입력받고 int로 변환
    for (int i = 1; i < 5; ++i) {
        string temp;
        cin >> temp;
        for (int j = 0; j < 8; ++j) {
            gear[i].push_back(temp[j] - '0');
        }
    }
    cin >> K;
    for (int i = 0; i < K; ++i) {
        int num, dir;
        cin >> num >> dir;
        rotate(num, dir);
    }
    int score = 1;
    for (int i = 1; i < 5; ++i) {
        if (gear[i][0] == 1) {
            answer += score;
        }
        score *= 2;
    }
    cout << answer;
    return 0;
}
