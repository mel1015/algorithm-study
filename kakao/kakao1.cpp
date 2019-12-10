//
// Created by sks10 on 2018-08-04.
//
#include <iostream>
#include <cmath>

using namespace std;

int first_award[6] = {500, 300, 200, 50, 30, 10};
int second_award[5] = {512, 256, 128, 64, 32};

int get_award(int first, int second) {
    int result = 0;
    bool get = false;
    for (int i = 0; i < 6; ++i) {
        if (first == 0 || first > 21) break;
        for (int j = 0; j <= i; ++j) {
            first--;
            if (first == 0) {
                result += first_award[i];
                get = true;
                break;
            }
        }
        if (get) break;
    }
    for (int k = 0; k < 5; ++k) {
        if (second == 0 || second > 31) break;
        second -= pow(2, k);
        if (second <= 0) {
            result += second_award[k];
            break;
        }
    }
    return result;
}

int main() {
    int t, first, second;
    cin >> t;
    for (int i = 0; i < t; ++i) {
        cin >> first >> second;
        cout << get_award(first, second) * 10000 << "\n";
    }
    return 0;
}
