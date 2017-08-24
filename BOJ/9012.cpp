//
// Created by sks10 on 2017-08-15.
//

#include <iostream>
#include <stack>

using namespace std;

int main() {
    stack<char> mystack;
    int n;
    char *ptr;
    string str;

    cin >> n;

    for (int k = 0; k < n; k++) {
        cin >> str;

        for (int i = 0; i < str.length(); i++) {

            mystack.push(str[i]);
            ptr = &mystack.top();
            if (str[0] == ')') {
                break;
            } else if (str[str.length()] == '(') {
                break;
            } else if (*ptr == ')' && *(--ptr) == '(') {
                mystack.pop();
                mystack.pop();
            }
        }

        if (mystack.empty()) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }

        while (!mystack.empty()) {
            mystack.pop();
        }
        str.clear();
    }
    return 0;
}
