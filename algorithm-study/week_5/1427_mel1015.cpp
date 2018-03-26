//
// Created by sks10 on 2018-01-27.
//
#include <iostream>
#include <algorithm>

using namespace std;

int main() {

    string n;

    cin >> n;

    // 알고리즘 헤더파일에서 제공하는 STL sort 사용
    sort(n.begin(), n.end());

    // 내림 차순
    for (long long int i = n.size() - 1; i >= 0; --i) {
        cout << n[i];
    }

    return 0;
}
