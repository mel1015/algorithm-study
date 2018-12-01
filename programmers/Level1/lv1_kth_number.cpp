//
// Created by sks10 on 2018-12-01.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    for (int i = 0; i < commands.size(); ++i) {
        int front, end, target;
        front = commands[i][0] - 1;
        end = commands[i][1];
        target = commands[i][2] - 1;

        vector<int> subarray(array.begin() + front, array.begin() + end);
        sort(subarray.begin(), subarray.end());
        answer.push_back(subarray[target]);
    }
    return answer;
}

int main() {
    vector<int> array = {1, 5, 2, 6, 3, 7, 4};
    vector<vector<int>> commands = {{2, 5, 3},
                                    {4, 4, 1},
                                    {1, 7, 3}};
    vector<int> answer = solution(array, commands);
    for (int i : answer) {
        cout << i << " ";
    }
    return 0;
}