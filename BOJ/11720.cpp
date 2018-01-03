//
// Created by sks10 on 2017-08-15.
//

#include <iostream>

using namespace std;

int main() {

    int n, result = 0;
    char *input;

    cin >> n;
    input = new char[n];
    for (int i = 0; i < n; i++) {
        cin >> input[i];
        result += ((int) input[i]) - 48;
    }
    cout << result << endl;

    return 0;
}