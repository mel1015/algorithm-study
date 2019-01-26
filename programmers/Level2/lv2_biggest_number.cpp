//
// Created by sks10 on 2019-01-23.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(string a, string b) {
    string make1 = "", make2 = "";
    make1 = a + b, make2 = b + a;
    return make1 > make2;
}


string solution(vector<int> numbers) {
    string answer = "";
    vector<string> strings;
    strings.reserve(numbers.size());

    for (int number : numbers) {
        strings.push_back(to_string(number));
    }
    sort(strings.begin(), strings.end(), compare);
    for (auto &string : strings) {
        answer += string;
    }
    if(answer[0] == '0') answer = "0";
    return answer;
}

int main() {
    vector<int> numbers = {0, 0, 0, 0};
    cout << solution(numbers);
    return 0;
}