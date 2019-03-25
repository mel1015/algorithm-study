//
// Created by sks10 on 2019-02-28.
//
#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> hashTable;

    for (auto cloth : clothes) {
        if (hashTable.end() == hashTable.find(cloth[1]))
            hashTable.insert({cloth[1], 1});
        else
            hashTable[cloth[1]]++;
    }
    for (auto &cloth : hashTable) {
        answer *= (cloth.second + 1);
    }
    return answer - 1;
}

int main() {
    vector<vector<string>> clothes =
            {{"yellow_hat",      "headgear"},
             {"blue_sunglasses", "eyewear"},
             {"green_truban",    "headgear"}};
    cout << solution(clothes);
    return 0;
}