//
// Created by sks10 on 2019-02-15.
//
#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    // map을 사용해서 중복값 찾기
    map<string, int> call;
    // map의 insert 결과를 bool형으로 저장
    pair<map<string, int>::iterator, bool> result;
    for (int i = 0; i < words.size(); ++i) {
        int word_length = words[i].length();
        result = call.insert(map<string, int>::
                             value_type(words[i], (i % n) + 1));
        // 중복 값이 나왔을 때
        if (!result.second) {
            answer.push_back((i % n) + 1);
            answer.push_back(i / n + 1);
            break;
        } else if (i < words.size() - 1 &&
                   words[i][word_length - 1] != words[i + 1][0]) {
            // 끝말을 못이었을 때
            answer.push_back(((i + 1) % n) + 1);
            answer.push_back((i + 1) / n + 1);
            break;
        }
    }
    // 틀린 사람이 없을 때
    if (answer.empty()) {
        answer.push_back(0);
        answer.push_back(0);
    }
    return answer;
}

int main() {
    int n = 2;
    vector<string> words = {"hello", "one", "even",
                            "never", "now", "world",
                            "draw"};
    vector<int> answer = solution(n, words);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}