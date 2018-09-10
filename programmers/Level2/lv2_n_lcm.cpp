//
// Created by sks10 on 2018-09-09.
//
#include <iostream>
#include <vector>

using namespace std;

// 최대 공약수
int GCD(int a, int b) {
    int c;
    while (b != 0) {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

// 최소 공배수
int LCM(int a, int b) {
    return a * b / GCD(a, b);
}

int solution(vector<int> arr) {
    int lcm = LCM(arr[0], arr[1]);
    for (int i = 2; i < arr.size(); ++i) {
        lcm = LCM(lcm, arr[i]);
    }
    return lcm;
}

int main() {
    vector<int> arr = {2, 6, 8, 14};
    cout << solution(arr);
    return 0;
}