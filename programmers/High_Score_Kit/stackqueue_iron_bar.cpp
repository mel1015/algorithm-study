//
// Created by sks10 on 2019-03-25.
//
#include <iostream>
#include <string>
#include <stack>

using namespace std;

int solution(string arrangement) {
    int answer = 0;
    stack<char> st;
    for (int i = 0; i < arrangement.length(); ++i) {
        // '(' 이면 스택에 넣음
        if (arrangement[i] == '(') st.push(arrangement[i]);
        else {
            // ')' 이면 스택에 들어있는 '(' 빼냄
            st.pop();
            // 바로 앞의 문자가 '('
            // 레이저가 만들어지면 막대기 개수 추가
            // 스택에 들어있는 '(' 의 개수가 막대기 개수
            if (arrangement[i - 1] == '(')
                answer += st.size();
            // 바로 앞의 문자가 ')'
            // 즉, 파이프의 끝이면 파이프 꼭다리 개수 1추가
            else answer++;
        }
    }

    return answer;
}

int main() {
    string arrangement;
    cin >> arrangement;
    cout << solution(arrangement);
    return 0;
}