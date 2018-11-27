//
// Created by sks10 on 2018-11-27.
//
#include <iostream>
#include <vector>
#include <math.h>
#include <ctime>

using namespace std;

long long solution(int N) {
    long long answer = 0;
    vector<int> arr(N + 1);

    for (int i = 2; i <= N; ++i) {
        arr[i] = i;
    }

    for (int i = 2; i <= N; ++i) {
        if (arr[i] == 0) continue;
        else answer += arr[i];

        for (int j = i + i; j <= N; j += i) {
            arr[j] = 0;
        }
    }

    return answer;
}

int main() {
//    clock_t start, end;
//    start = clock();
    int n;
    cin >> n;
    cout << solution(n) << endl;
//    end = clock();

//    double time = (double) (end - start) / CLOCKS_PER_SEC;
//    cout << "수행시간 : " << time;

    return 0;
}