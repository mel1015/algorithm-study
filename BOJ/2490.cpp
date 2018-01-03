//
// Created by sks10 on 2017-09-09.
//

#include <iostream>

using namespace std;

int main() {

    int arr[4];

    for (int i = 0; i < 3; ++i) {
        int count = 0;
        for (int j = 0; j < 4; ++j) {
            cin >> arr[j];
            if (arr[j] == 0) {
                count++;
            }
        }
        if (count == 1) {
            cout << "A" << endl;
            continue;
        } else if (count == 2) {
            cout << "B" << endl;
            continue;
        } else if (count == 3) {
            cout << "C" << endl;
            continue;
        } else if (count == 4) {
            cout << "D" << endl;
            continue;
        } else
            cout << "E" << endl;
    }
    return 0;
}