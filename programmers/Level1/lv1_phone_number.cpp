//
// Created by sks10 on 2019-01-09.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    string answer = "";
    phone_number.replace(phone_number.begin(), phone_number.end() - 4,
                         (int)phone_number.size() - 4, '*');
    answer += phone_number;
    return answer;
}

int main() {
    string phone_number = "01033334444";
    cout << solution(phone_number);
    return 0;
}