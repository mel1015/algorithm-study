//
// Created by sks10 on 2019-01-18.
//
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    for (int i = 0; i < skill_trees.size(); ++i) {
        bool is_good = true;
        string skill_tree = skill_trees[i];
        cout << skill_tree << endl;
        int pre_skill_index = 0;
        for (int j = 0; j < skill_trees[i].length(); ++j) {
            char learned_skill = skill_trees[i][j];
            char pre_skill = skill[pre_skill_index];

            cout << learned_skill << " is same with " << pre_skill << "?  ";

            size_t found = skill.find(learned_skill);
            if (found == -1) {
                cout << "not in pre skill list" << endl;
                continue;
            } else {
                if (found != pre_skill_index) {
                    cout << "wrong" << endl;
                    is_good = false;
                    break;
                } else {
                    cout << "yes" << endl;
                    pre_skill_index++;
                    continue;
                }
            }
        }
        if (is_good) answer++;
        cout << endl;
    }
    return answer;
}

int main() {
    string skill = "CBD";
    vector<string> skill_trees = {"BACDE", "CBADF",
                                  "AECB", "BDA"};
    cout << solution(skill, skill_trees);
    return 0;
}