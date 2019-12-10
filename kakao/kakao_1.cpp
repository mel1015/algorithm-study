//
// Created by sks10 on 2018-09-15.
//
#include <iostream>
#include <vector>
#include <sstream>
#include <regex>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    vector<vector<string>> words;
    words.resize(record.size());
    for (int i = 0; i < record.size(); ++i) {
        istringstream iss(record[i]);
        copy(istream_iterator<string>(iss),
             istream_iterator<string>(),
             back_inserter(words[i]));
    }
    for (int i = 0; i < words.size(); ++i) {
        if (words[i][0] == "Enter" || words[i][0] == "Change") {
            string id = words[i][1];
            string nickname = words[i][2];
            for (int j = 0; j < words.size(); ++j) {
                if (words[j][0] == "Enter" && words[j][1] == id) {
                    words[j][2] = nickname;
                }
            }
        }
    }
    for (int i = 0; i < words.size(); ++i) {
        if (words[i][0] == "Enter") {
            string ss = words[i][2] + "님이 들어왔습니다.";
            answer.emplace_back(ss);
        } else if (words[i][0] == "Leave") {
            for (int j = 0; j < words.size(); ++j) {
                if (words[i][1] == words[j][1]) {
                    string ss = words[j][2] + "님이 나갔습니다.";
                    answer.emplace_back(ss);
                    break;
                }
            }
        }
    }
    return answer;
}

int main() {
    vector<string> record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                             "Leave uid1234", "Enter uid1234 Prodo",
                             "Change uid4567 Ryan"};
    vector<string> answer = solution(record);
    for (int i = 0; i < answer.size(); ++i) {
        cout << answer[i] << endl;
    }
}