//
// Created by sks10 on 2018-09-14.
//
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <iterator>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    // 정렬
    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());
    for (int i = 0; i < completion.size(); ++i) {
        // 완주자 목록에 없으면 리턴
        if (participant[i] != completion[i]) {
            return participant[i];
        }
    }
    // 참여자 목록의 마지막 사람이 완주 못했을 때
    return participant[participant.size() - 1];
}

int main() {
    vector<string> participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
    vector<string> completion = {"josipa", "filipa", "marina", "nikola"};
    cout << solution(participant, completion);
    return 0;
}