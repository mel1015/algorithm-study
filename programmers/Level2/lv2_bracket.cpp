//
// Created by sks10 on 2018-09-07.
//
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s) {
    bool answer = false;
    stack<char> st;

    for (int i = 0; i < s.length(); ++i) {
        if (s[0] == ')') return answer;
        if (!st.empty() && st.top() == '(' && s[i] == ')') {
            st.pop();
            continue;
        }
        st.push(s[i]);
    }
    if (st.empty()) answer = true;
    return answer;
}

int main() {
    string s;

    cin >> s;
    cout << solution(s);

    return 0;
}
