//

//
// Created by sks10 on 2017-08-29.
//
// 파스칼의 삼각형
// n=0  1               0C0
// n=1  1 1             1C0 1C1
// n=2  1 2 1           2C0 2C1 2C2
// n=3  1 3 3 1         3C0 3C1 3C2 3C3
// n=4  1 4 6 4 1       4C0 4C1 4C2 4C3 4C4
// bino[0] 과 bino[n] 을 1로 초기화해주고
// bino[r] = bino[r] + bino[r-1] 로 초기화 해나가면
// 파스칼의 삼각형이 만들어진다
// 이항계수의 성질 nCr = n-1Cr-1 + n-1Cr 을 이용

#include <iostream>

using namespace std;

int bino[1001] = {1};

int main() {

    int n, k;

    cin >> n >> k;

    for (int i = 0; i < n; i++) {
        bino[i + 1] = 1;
        for (int j = i; j > 0; --j) {
            bino[j] = (bino[j] + bino[j - 1]) % 10007;
        }
    }
    cout << bino[k] << endl;

    return 0;
}