//
// Created by sks10 on 2017-10-07.
//

#include <iostream>

using namespace std;

void find_sequence(long long n, int l);

int main() {

    long long n;
    int l;

    cin >> n >> l;

    find_sequence(n, l);

    return 0;
}

void find_sequence(long long n, int l) {
    long long x;

    while (l <= 100) {
        if ((l + 1) % 2 == 0) {
            if (n % l != 0) {
                l++;
                continue;
            } else if (n % l == 0) {
                x = n / l;
                int side = -(l / 2);

                if ((x + side) < 0) {
                    l++;
                    continue;
                } else {
                    for (int i = 0; i < l; ++i) {
                        cout << x + side << " ";
                        side++;
                    }
                    break;
                }
            }
        } else if (l % 2 == 0) {
            int turn = l / 2;

            if ((n + turn) % l != 0) {
                l++;
                continue;
            } else if ((n + turn) % l == 0) {
                long long temp = n + turn;
                x = temp / l;
                turn = -turn;

                if ((x + turn) < 0) {
                    l++;
                    continue;
                } else {
                    for (int i = 0; i < l; ++i) {
                        cout << x + turn << " ";
                        turn++;
                    }
                    break;
                }
            }
        }
    }
    if(l>100){
        cout << -1;
    }
}
