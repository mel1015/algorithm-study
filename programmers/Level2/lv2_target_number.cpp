//
// Created by sks10 on 2019-02-11.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int answer = 0;

void DFS(vector<int> numbers, int target, int sum, int index) {
    if (index == numbers.size()) {
        if (sum == target) answer++;
        return;
    }
    DFS(numbers, target, sum + numbers[index], index + 1);
    DFS(numbers, target, sum - numbers[index], index + 1);
}


int solution(vector<int> numbers, int target) {
    // 더하는 경우와 빼는 경우
    DFS(numbers, target, numbers[0], 1);
    DFS(numbers, target, -numbers[0], 1);
    return answer;
}

int main() {
    vector<int> numbers = {4, 2, 6, 1, 5};
    int target = 2;
    cout << solution(numbers, target) << endl;
    return 0;
}