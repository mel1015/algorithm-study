//
// Created by sks10 on 2019-01-29.
//
// 출처 [http://gall.dcinside.com/mgallery/board/view/?id=ps&no=1196&page=1]
#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    stack<char> st;
    for (int i = 0; i < number.length(); ++i) {
        // 스택에 넣을 숫자
        char pushNum = number[i];
        // 스택의 top과 pushNum을 비교해서
        // pushNum이 탑보다 크면 top을 pop
        // pop한 후의 top과 pushNum 다시 비교
        for (; !st.empty() && k > 0; --k) {
            char onTop = st.top();
            if (onTop >= pushNum) break;
            st.pop();
        }
        st.push(pushNum);
    }
    for (; k > 0; --k) {
        st.pop();
    }
    while (!st.empty()) {
        answer += st.top();
        st.pop();
    }
    reverse(answer.begin(), answer.end());
    return answer;
}

int main() {
    string number;
    int k;
    cin >> number >> k;
    cout << solution(number, k);
    return 0;
}