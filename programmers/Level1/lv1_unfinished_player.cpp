//
// Created by sks10 on 2018-11-27.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());

    for (int i = 0; i < completion.size(); i++) {
        if (participant[i] != completion[i])
            return participant[i];
    }
    return participant[participant.size() - 1];
}

int main() {
//    vector<string> participant = {"leo", "kiki", "eden"};
//    vector<string> completion = {"eden", "kiki"};
    vector<string> participant = {"mislav", "stanko", "mislav", "ana"};
    vector<string> completion = {"stanko", "ana", "mislav"};

    cout << solution(participant, completion);
    return 0;
}
