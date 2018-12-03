//
// Created by sks10 on 2018-12-03.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    string answer = "";
    vector<int> days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    vector<string> day = {
            "THU", "FRI", "SAT", "SUN",
            "MON", "TUE", "WED"
    };

    int day_count = 0;
    for (int i = 0; i < a - 1; ++i) {
        day_count += days[i];
    }
    day_count += b;
    answer = day[day_count % 7];
    return answer;
}

int main() {
    int a, b;
    cin >> a >> b;
    cout << solution(a, b);
    return 0;
}