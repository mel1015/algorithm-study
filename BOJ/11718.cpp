//
// Created by sks10 on 2017-08-15.
//

#include <iostream>

using namespace std;

int main() {
    string input;

    for (int i = 0; i < 100; ++i) {
        getline(cin, input, '\n');
        cout << input << endl;
    }
    return 0;
}