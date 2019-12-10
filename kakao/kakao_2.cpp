#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    answer.resize(N + 1);
    vector<double> dp;
    dp.resize(N + 1);

    for (int i = 0; i < stages.size(); ++i) {
        if (stages[i] == N + 1) {
            answer[N] = 0;
            continue;
        }
        answer[stages[i]]++;
    }

    dp[1] = (double) answer[1] / stages.size();
    int sum = answer[1];
    for (int i = 2; i < answer.size(); ++i) {
        dp[i] = (double) answer[i] / (stages.size() - sum);
        sum += answer[i];
    }
    answer.clear();

    vector<double>::iterator high;
    while (true) {
        if (answer.size() == N) break;
        high = max_element(dp.begin() + 1, dp.end());
        answer.emplace_back(distance(dp.begin(), high));
        *high = -1;
    }
    return answer;
}

int main() {
    vector<int> stages = {2, 1, 2, 6, 2, 4, 3, 3};
    vector<int> arr = solution(5, stages);
    for (int i : arr) {
        cout << i << " ";
    }
    return 0;
}