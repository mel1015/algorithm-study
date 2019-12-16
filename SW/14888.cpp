//
// Created by sks10 on 2019-04-05.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, maxValue = -INT32_MAX, minValue = INT32_MAX;
vector<int> numbers;
vector<int> afterCalc;
vector<int> op;
// +, -, *, / 순의 연산자 개수
int opCount[4];


int calc(int x, int y, int op) {
    // 연산
    switch (op) {
        case 1:
            return x + y;
        case 2:
            return x - y;
        case 3:
            return x * y;
        case 4:
            return x / y;
        default:
            break;
    }
}

void solution() {
    do {
        // permutaiton을 사용해서
        // 모든 연산자 순서 조합 생성
        afterCalc = numbers;
        int idx = 0;
        for (int i = 0; i < N - 1; ++i) {
            afterCalc[idx + 1] = calc(afterCalc[idx], afterCalc[idx + 1], op[i]);
            idx++;
        }
        maxValue = max(maxValue, afterCalc[N - 1]);
        minValue = min(minValue, afterCalc[N - 1]);
    } while (next_permutation(op.begin(), op.end()));
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    numbers.resize(N);
    afterCalc.resize(N);
    op.resize(N - 1);
    for (int i = 0; i < N; ++i) {
        cin >> numbers[i];
    }
    int idx = 0;
    for (int i = 0; i < 4; ++i) {
        cin >> opCount[i];
        for (int j = 0; j < opCount[i]; ++j) {
            // 연산자 개수만큼 op 배열에 저장
            if (i == 0) op[idx++] = 1;
            else if (i == 1) op[idx++] = 2;
            else if (i == 2) op[idx++] = 3;
            else if (i == 3) op[idx++] = 4;
        }
    }
    solution();
    cout << maxValue << endl << minValue;
    return 0;
}
