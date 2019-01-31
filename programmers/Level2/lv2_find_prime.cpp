//
// Created by sks10 on 2019-01-29.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int solution(string numbers) {
    int answer = 0;
    string temp = numbers;
    sort(temp.begin(), temp.end(), greater<char>());

    int n = stoi(temp);
    vector<int> prime(n + 1);

    // 2부터 n까지 배열 초기화
    for (int i = 2; i <= n; ++i) {
        prime[i] = i;
    }

    for (int i = 2; i <= n; ++i) {
        // 배열의 값이 0이면 소수가 아님
        if (prime[i] == 0) continue;
        // 2 => 4, 6, 8 ,10 을 0으로
        // 3 => 6, 9 를 0으로
        // 자신의 배수를 0으로 체크하여 소수 판별 안하도록
        for (int j = i + i; j <= n; j += i) {
            prime[j] = 0;
        }
    }

    // 작은 수열부터 만들어야 하므로
    sort(temp.begin(), temp.end());
    int size = numbers.length();
    do {
        for (int i = 1; i <= size; ++i) {
            string sub = temp.substr(0, i);
            n = stoi(sub);
            if (prime[n]) {
                answer++;
                // 중복 제거
                prime[n] = 0;
            }
        }
    } while (next_permutation(temp.begin(), temp.end()));
    return answer;
}

int main() {
    string numbers;
    cin >> numbers;
    cout << solution(numbers);
    return 0;
}