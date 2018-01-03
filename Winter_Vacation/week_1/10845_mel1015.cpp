//
// Created by sks10 on 2018-01-01.
//
#include <iostream>
#include <queue>

using namespace std;
int n, a;
queue<int> myqueue;
string cmd;

int main() {

    for (cin >> n; n; n--) {
        cin >> cmd;
        if (cmd == "push") {
            cin >> a;
            myqueue.push(a);
        } else if (cmd == "pop") {
            if (myqueue.empty())
                cout << -1 << endl;
            else {
                cout << myqueue.front() << endl;
                myqueue.pop();
            }
        } else if (cmd == "size") {
            cout << myqueue.size() << endl;
        } else if (cmd == "empty") {
            if (myqueue.empty())
                cout << 1 << endl;
            else
                cout << 0 << endl;
        } else if (cmd == "front") {
            if (myqueue.empty())
                cout << -1 << endl;
            else
                cout << myqueue.front() << endl;
        } else if (cmd == "back") {
            if (myqueue.empty())
                cout << -1 << endl;
            else
                cout << myqueue.back() << endl;
        }
    }
    return 0;
}

