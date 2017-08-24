//
// Created by sks10 on 2017-08-17.
//

#include <iostream>

using namespace std;

int main() {
    int n, *score;
    double aver = 0, total = 0, max = 0;

    cin >> n;

    score = new int[n];

    for (int i = 0; i < n; ++i) {

        cin >> score[i];
        if (score[i] > max) {
            max = score[i];
        }
    }

    for (int j = 0; j < n; ++j) {
        total += ((score[j] / max) * 100);
    }

    aver = total / n;

    cout << fixed;
    cout.precision(2);
    cout << aver << endl;

    return 0;
}