//
// Created by sks10 on 2019-01-09.
//
#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

typedef long long ll;

ll solution(ll n) {
    ll answer = 0;
    double a = sqrt(n);
    int b = int(a);
    if ((a - b) > 0) return -1;
    else {
        answer = ll(pow(a + 1, 2.0));
    }
    return answer;
}

int main() {
    int n;
    cin >> n;
    cout << solution(n);
    return 0;
}