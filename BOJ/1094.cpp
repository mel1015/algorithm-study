//
// Created by sks10 on 2017-09-19.
//
// 64를 계속 반으로 나누므로
// 나올수 있는 수는 {64, 32, 16, 8, 4, 2, 1} 뿐
// 따라서 찾는 수 x를 2진수로 바꾼 후
// 2진수에서의 x가 1이 몇 개인지 센다.

#include <iostream>

using namespace std;


int main() {

    int x, count = 0, result[6];
    cin >> x;

    for (int i = 0; x > 0; ++i) {
        result[i] = x % 2;
        x = x / 2;
        if (result[i] == 1) {
            count++;
        }
    }
    cout << count << endl;

    return 0;
}