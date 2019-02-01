//
// Created by sks10 on 2019-02-01.
//
#include <iostream>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> kinds;
    pair<map<string, int>::iterator, bool> result;
    for (int i = 0; i < clothes.size(); ++i) {
        result = kinds.insert(map<string, int>::
                              value_type(clothes[i][1], 1));
        if (!result.second) {
            kinds.find(clothes[i][1])->second++;
        }
    }

    for (auto &kind : kinds) {
        answer *= (kind.second + 1);
    }
    return answer - 1;
}

int main() {
    vector<vector<string>> clothes =
            {{"yellow_hat",      "headgear"},
             {"blue_sunglasses", "eyewear"},
             {"aa",              "eyewear"},
             {"bb",              "eyewear"},
             {"green_truban",    "headgear"},
             {"aa",              "pants"},
             {"bb",              "pants"},
             {"cc",              "pants"},
             {"dd",              "pants"},
             {"aa",              "coat"}};
    cout << solution(clothes);
    return 0;
}