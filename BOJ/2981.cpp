//
// Created by sks10 on 2017-09-15.
//
// 약수들의 특성 -> 서로 짝을 이룸.
// N의 약수 i가 있으면 N/i도 약수이다.
// 100의 약수 = {1, 2, 4, 5, 20, 25, 50, 100} 에서
// 1,2,4,5 까지 확인했으면 20,25,50,100 은 N/i 로 구할 수 있다.
// -> 범위를 i*i <= N 까지 또는 i <= sqrt(N)-1 로 줄일 수 있음.

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    vector<long long> arr, divisors;
    long long n, m;

    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> m;
        arr.push_back(m);
    }
    sort(arr.begin(), arr.end());

    long long target = arr[n - 1] - arr[0];
    for (long long i = 1; i * i <= target; ++i) {
        if (target % i == 0) {
            divisors.push_back(i);
            if (i != target / i)
                divisors.push_back(target / i);
        }
    }
    sort(divisors.begin(), divisors.end());

    for (int i = 1; i < divisors.size(); ++i) {
        int count = 1;
        for (int j = 1; j < n; ++j) {
            long long mod = arr[j - 1] % divisors[i];
            if (arr[j] % divisors[i] == mod) {
                count++;
            }
        }
        if (count == n) {
            cout << divisors[i] << " ";
        }
    }
    return 0;
}
