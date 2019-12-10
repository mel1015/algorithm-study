//
// Created by sks10 on 2018-09-22.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, vector<int> tshirts) {
    int answer = 0;
    sort(people.begin(), people.end());
    sort(tshirts.begin(), tshirts.end());
    for (int i = 0; i < people.size(); ++i) {
        for (auto it = tshirts.begin(); it != tshirts.end(); ++it) {
            if (people[i] <= *it) {
                answer++;
                tshirts.erase(it);
                break;
            }
        }
    }

    return answer;
}

int main() {
    vector<int> people = {1, 2, 3};
    vector<int> tshirts = {1, 1};
    cout << solution(people, tshirts);
    return 0;
}