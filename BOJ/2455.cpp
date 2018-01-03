//
// Created by sks10 on 2017-09-19.
//

#include <iostream>
#include <algorithm>

using namespace std;

int main() {

    int in, out, total[4];

    cin >> out >> in;
    total[0] = in - out;
    for (int i = 1; i < 4; ++i) {
        cin >> out >> in;
        total[i] = total[i - 1] + in - out;
    }
    cout << *max_element(total, total + 4);

    return 0;
}