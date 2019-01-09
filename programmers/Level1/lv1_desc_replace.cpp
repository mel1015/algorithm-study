//
// Created by sks10 on 2019-01-07.
//
#include <iostream>
#include <math.h>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

bool desc(int a, int b) {
    return a > b;
}

ll solution(ll n) {
    ll answer = 0;
    int count = 0;
    vector<int> arr;
    while (n != 0) {
        arr.push_back(n % 10);
        n /= 10;
        count++;
    }
    sort(arr.begin(), arr.end(), desc);
    for (int i = 0; i < count; ++i) {
        // 실행창에선 pow()함수의 값 누락이 있으나
        // 제출시엔 오류가 없음
        int a = static_cast<int>(pow(10.0, count - i - 1));
        answer += ll(arr[i] * a);
    }
    return answer;
}

int main() {
    ll n;
    cin >> n;
    cout << solution(n);
    return 0;
}