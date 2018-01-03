//
// Created by sks10 on 2017-08-20.
//

#include <iostream>

using namespace std;

int main() {
    int T, H, W, N, count;

    cin >> T;

    while (T--) {
        cin >> H >> W >> N;
        count = 0;
        for (int i = 1; i <= W; ++i) {
            for (int j = 1; j <= H; ++j) {
                count++;
                if (count == N) {
                    if (i < 10) {
                        cout << j << 0 << i << endl;
                    } else
                        cout << j << i << endl;
                }
            }
        }
    }
    return 0;
}