//
// Created by sks10 on 2019-02-15.
//
#include <iostream>

using namespace std;

int solution(int n, int a, int b) {
    int answer = 0;
    while (a != b) {
        // 시합 후 새로 매겨지는 번호
        // (1,2) => 1, (3,4) => 2, ...
        // a==b 가 되는 순간이 만나는 순간
        if (a % 2 == 0) {
            a /= 2;
        } else {
            a /= 2;
            a++;
        }
        if (b % 2 == 0) {
            b /= 2;
        } else {
            b /= 2;
            b++;
        }
        answer++;
    }
    return answer;
}

int main() {
    int n, a, b;
    cin >> n >> a >> b;
    cout << solution(n, a, b);
    return 0;
}
