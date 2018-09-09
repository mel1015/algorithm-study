//
// Created by sks10 on 2018-09-09.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());

    // 정렬 후 (A의 가장 작은 값 * B의 가장 큰 값)
    for (int i = 0; i < A.size(); ++i) {
        answer += A[i] * B[A.size() - 1 - i];
    }
    return answer;
}

int main() {
    vector<int> A = {1, 4, 2};
    vector<int> B = {5, 4, 4};
    cout << solution(A, B);

    return 0;
}
