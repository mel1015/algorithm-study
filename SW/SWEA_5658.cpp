//
// Created by sks10 on 2019-06-18.
//
#include <iostream>
#include <vector>
#include <deque>
#include <algorithm>

#define endl "\n"

using namespace std;

int N, K, TC;
deque<char> password;

void init() {
    cin >> N >> K;
    for (int i = 0; i < N; ++i) {
        char x;
        cin >> x;
        password.push_back(x);
    }
}

long long rotate() {
    vector<long long> hexToDec;
    int side = N / 4;
    for (int i = 0; i < side; ++i) {
        string hex = "";
        int count = 0;
        for (int j = 0; j < N; ++j) {
            hex += password[j];
            count++;
            if (count == side) {
                int nDex = stoi(hex, nullptr, 16);
                hexToDec.push_back(nDex);
                hex = "";
                count = 0;
            }
        }
        char back = password.back();
        password.push_front(back);
        password.erase(password.end() - 1);
    }
    sort(hexToDec.begin(), hexToDec.end(), greater<int>());
    hexToDec.erase(unique(hexToDec.begin(), hexToDec.end()), hexToDec.end());
    return hexToDec[K - 1];
}

void solution() {
    cin >> TC;
    long long answer = 0;
    for (int i = 1; i <= TC; ++i) {
        init();
        answer = rotate();
        password.clear();
        cout << "#" << i << " " << answer << endl;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    solution();

    return 0;
}
