//
// Created by sks10 on 2018-07-12.
//
#include <iostream>
#include <vector>

using namespace std;

vector<int> password;

int main() {
    int length, data;
    for (int testCase = 1; testCase <= 10; ++testCase) {
        cin >> length;
        for (int i = 0; i < length; ++i) {
            scanf("%1d", &data);
            password.push_back(data);
            if (password.size() > 1) {
                if (data == *(password.end() - 2)) {
                    password.pop_back();
                    password.pop_back();
                }
            }
        }
        cout << "#" << testCase << " ";
        for (int j : password) {
            cout << j;
        }
        cout << "\n";
        password.clear();
    }
    return 0;
}
