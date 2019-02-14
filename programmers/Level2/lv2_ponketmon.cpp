//
// Created by sks10 on 2019-02-14.
//
#include <iostream>
#include <vector>
#include <map>

using namespace std;

int solution(vector<int> nums) {
    int answer = 0;
    map<int, int> get;
    for (int i = 0; i < nums.size(); ++i) {
        get.insert(make_pair(nums[i],0));
    }
    if (nums.size() / 2 <= get.size()) {
        answer = nums.size() / 2;
    } else {
        answer = get.size();
    }
    return answer;
}

int main() {
    vector<int> nums = {3, 3, 3, 2, 2, 2};
    cout << solution(nums);
    return 0;
}