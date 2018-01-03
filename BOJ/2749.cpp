//
// Created by sks10 on 2017-08-26.
//
// 피보나치 수열을 m으로 나눈 나머지가 주기를 이룬다
// => 피사노 주기
// 주기의 길이가 P 이면, N번째 피보나치 수를 M으로 나눈 나머지는
// N % P번째 피보나치 수를 M으로 나눈 나머지와 같다.
// https://www.acmicpc.net/blog/view/28

#include <iostream>

using namespace std;

const int mod = 1000000;
const int cycle = 15 * 100000;
int fibo[cycle] = {0, 1};

int main() {
    long long int n;
    cin >> n;
    for (int i = 2; i < cycle; ++i) {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
        fibo[i] = fibo[i] % mod;
    }
    cout << fibo[n % cycle] << endl;

    return 0;
}