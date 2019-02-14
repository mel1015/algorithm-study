//
// Created by sks10 on 2019-02-14.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int solution(vector<int> nums) {
    int answer = 0;
    // 숫자중 3개 뽑는 조합
    vector<int> combi;
    for (int i = 0; i < nums.size() - 3; ++i) {
        combi.push_back(0);
    }
    for (int j = 0; j < 3; ++j) {
        combi.push_back(1);
    }

    // next_permutation()을 사용해서
    // 3개의 숫자 뽑기
    do {
        int number = 0, count = 0;
        bool isPrime = true;
        // 3개의 숫자를 더하고
        for (int i = 0; i < combi.size(); ++i) {
            if (combi[i]) number += nums[i];
        }
        // 소수 판별
        for (int j = 1; j <= sqrt(number); ++j) {
            if (number % j == 0) count++;
            if (count > 1) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) answer++;
    } while (next_permutation(combi.begin(), combi.end()));
    return answer;
}

int main() {
    vector<int> nums = {1, 2, 7, 6,4};
    cout << solution(nums);
    return 0;
}
