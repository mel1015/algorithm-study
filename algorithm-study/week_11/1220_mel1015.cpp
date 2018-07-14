//
// Created by sks10 on 2018-07-14.
//
#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> table;

int check_Deadlock() {
    for (auto &i : table) {
        // 1개일 때는 그냥 빠져나감
        if (i.size() == 1) {
            i.clear();
            continue;
        }
        // N극으로 빠져나감
        for (auto it = i.begin(); it != i.end(); it++) {
            it = i.begin();
            if (*it != 2) break;
            if (*it == 2) i.erase(it);
        }
        // S극으로 빠져나감
        for (auto it = i.end() - 1; it >= i.begin(); it--) {
            it = i.end() - 1;
            if (*it != 1) break;
            if (*it == 1) i.erase(it);
        }
    }
    // 교착상태 체크
    int next, count = 0;
    for (auto &i : table) {
        if (i.empty()) continue;
        for (int j = 0; j < i.size() - 1; ++j) {
            next = i[j + 1];
            if (i[j] == 1 && next == 2) count++;
        }
    }
    return count;
}

int main() {
    int edge, data;
    for (int testCase = 1; testCase <= 10; ++testCase) {
        cin >> edge;
        table.resize(edge);
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 100; ++j) {
                cin >> data;
                // 0이 아닌 데이터만 해당 열에 저장
                if (data != 0) table[j].push_back(data);
            }
        }
        cout << "#" << testCase << " " << check_Deadlock() << "\n";
        table.clear();
    }
    return 0;
}
