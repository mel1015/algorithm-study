//
// Created by sks10 on 2019-03-22.
//
#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

// 장르별 플레이 횟수 비교
bool comp(pair<int, string> a, pair<int, string> b) {
    return a.first > b.first;
}
// 곡의 플레이 횟수와 고유 번호 비교
bool comp1(pair<int, int> a, pair<int, int> b) {
    if (a.first == b.first) return a.second < b.second;
    return a.first > b.first;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    map<string, int> hashTable;
    // 장르를 Key로 하여 Value값에 플레이 횟수 가산
    for (int i = 0; i < genres.size(); ++i) {
        if (hashTable.end() == hashTable.find(genres[i])) {
            hashTable.insert({genres[i], plays[i]});
        } else {
            hashTable[genres[i]] += plays[i];
        }
    }
    // 장르별 총 플레이 횟수를 내림차순으로 정렬
    vector<pair<int, string>> genreList;
    genreList.reserve(hashTable.size());
    for (auto &it : hashTable) {
        genreList.emplace_back(it.second, it.first);
    }
    sort(genreList.begin(), genreList.end(), comp);

    // 가장 많이 재생된 장르부터
    // 해당 장르의 곡들의 플레이 횟수와 고유 번호 저장
    vector<vector<pair<int, int>>> playID;
    playID.resize(genreList.size());
    for (int i = 0; i < genreList.size(); ++i) {
        for (int j = 0; j < genres.size(); ++j) {
            if (!genreList[i].second.compare(genres[j])) {
                playID[i].push_back(make_pair(plays[j], j));
            }
        }
    }

    for (int i = 0; i < playID.size(); ++i) {
        // 플레이 횟수와 고유 번호로 정렬
        sort(playID[i].begin(), playID[i].end(), comp1);
        // 한 곡만 있을 때와 여러곡 있을 때 나눔
        if(playID[i].size() == 1){
            answer.push_back(playID[i][0].second);
        }else{
            answer.push_back(playID[i][0].second);
            answer.push_back(playID[i][1].second);
        }
    }
    return answer;
}

int main() {
    vector<string> genres = {"classic", "pop", "classic",
                             "classic", "pop"};
    vector<int> plays = {500, 600, 150, 800, 2500};
    vector<int> answer = solution(genres, plays);
    for (auto i : answer) {
        cout << i << " ";
    }
    return 0;
}