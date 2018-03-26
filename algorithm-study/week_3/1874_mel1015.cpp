//
// Created by sks10 on 2018-01-16.
//
#include <iostream>
#include <stack>
#include <queue>

using namespace std;

int main() {
    stack<int> st;
    queue<char> result;
    int *sequence;
    int n;

    // n개의 수열 입력
    scanf("%d", &n);
    sequence = new int[n];
    for (int i = 0; i < n; ++i) {
        scanf("%d", &sequence[i]);
    }

    int index = 0, count = 0;
    for (int j = 1; j <= n; ++j) {
        // 스택에 1부터 n까지 push
        st.push(j);
        result.push('+');
        while (!st.empty() && st.top() == sequence[index] && index < n) {
            // 스택의 top이 수열과 일치하면 pop
            st.pop();
            result.push('-');
            // index를 증가시켜 수열의 다음 수로, 카운트로 개수 확인
            index++, count++;
        }
    }
    if (count == n) {
        // 수열의 개수가 모두 나왔다면 정답을 출력
        while (!result.empty()) {
            printf("%c\n", result.front());
            result.pop();
        }
    } else {
        printf("NO\n");
    }

    return 0;
}
