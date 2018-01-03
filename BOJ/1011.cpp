//
// Created by sks10 on 2017-08-20.
//

#include <iostream>
#include <math.h>

using namespace std;

int main() {
    int cases;
    unsigned int start, destination, remanning;
    double mid;

    cin >> cases;

    for (int i = 0; i < cases; ++i) {
        cin >> start >> destination;
        remanning = destination - start;
        for (int j = 1; j <= remanning; ++j) {
            if (remanning == pow(j, 2)) {
                cout << 2 * j - 1 << endl;
            } else if (remanning > pow(j, 2) && remanning <= pow(j + 1, 2)) {
                mid = ((2 * j) + 1) / 2.0;
                if (sqrt((double) remanning) >= mid) {
                    cout << 2 * j + 1 << endl;
                    break;
                } else {
                    cout << 2 * j << endl;
                    break;
                }
            }
        }
    }
    return 0;
}