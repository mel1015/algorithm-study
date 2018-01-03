//
// Created by sks10 on 2017-09-19.
//
// 2명 -> 1명
// 줄여나가면서 같아지면 만난 것.

#include <iostream>

using namespace std;

int main() {

    int n, jimin, hansu, count = 0;
    cin >> n >> jimin >> hansu;

    while (jimin != hansu) {
        jimin = (jimin + 1) / 2;
        hansu = (hansu + 1) / 2;
        count++;
    }
    cout << count;

    return 0;
}