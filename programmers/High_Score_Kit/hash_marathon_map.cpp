//
// Created by sks10 on 2019-02-28.
//
#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    map<string, int> hashTable;

    // 완주자 목록으로 해시 테이블 구성
    for (auto name : completion) {
        // map::find => 찾는 key가 있으면 iterator 리턴
        // 없으면 map::end 리턴
        if (hashTable.end() == hashTable.find(name))
            hashTable.insert({name, 1});
        else
            hashTable[name]++;
    }

    for (auto name : participant) {
        if (hashTable.end() == hashTable.find(name)) {
            answer = name;
            break;
        } else {
            // 동명이인 체크
            hashTable[name]--;
            if (hashTable[name] < 0) {
                answer = name;
                break;
            }
        }
    }
    return answer;
}

int main() {
    vector<string> participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
    vector<string> completion = {"josipa", "filipa", "marina", "nikola"};
    cout << solution(participant, completion);
    return 0;
}