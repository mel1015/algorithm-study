//
// Created by sks10 on 2019-03-28.
//
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer(prices.size());
    stack<int> st;
    int size = prices.size();
    for (int i = 0; i < size; i++) {
        // 이전 값(st.top())과 현재 값(prices[i]) 비교
        // 주가가 떨어지는 위치(i)를 찾고
        // 이전 값과의 인덱스차(시간) 계산, 저장 후 pop()
        // pop() 했으면 다시 그 이전 값(st.top())과 비교
        while (!st.empty() && prices[st.top()] > prices[i]) {
            answer[st.top()] = i - st.top();
            st.pop();
        }
        // 떨어지지 않으면 스택에 넣음
        st.push(i);
    }
    // 떨어지는 지점 처리는 끝났으니
    // 현재 스택에 있는 값은 끝까지 떨어지지 않음
    while (!st.empty()) {
        answer[st.top()] = size - st.top() - 1;
        st.pop();
    }
    return answer;
}

int main() {
    vector<int> prices = {1, 2, 3, 2, 3};
    vector<int> answer = solution(prices);
    for (int i:answer) {
        cout << i << " ";
    }
    return 0;
}