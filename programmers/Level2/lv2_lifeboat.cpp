//
// Created by sks10 on 2019-02-10.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end(), greater<int>());
    // 가장 무거운 사람(people[i])을 태우고
    // 가장 가벼운 사람(people[j])을 추가로 태울 수 있으면 j--;
    for (int i = 0, j = people.size() - 1; i <= j; ++i) {
        if (people[i] + people[j] <= limit) j--;
        answer++;
    }
    return answer;
}

int main() {
    vector<int> people = {10, 20, 30, 40, 50, 60, 70, 80, 90};
//    vector<int> people = {50, 70, 80, 50};
    int limit = 100;
    cout << solution(people, limit);
    return 0;
}