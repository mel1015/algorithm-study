//
// Created by sks10 on 2017-08-26.
//

#include <iostream>
#include <deque>

using namespace std;

int main() {

    deque<int> mydeque;
    int n, x;
    string cmd;

    cin >> n;

    while (n--) {
        cin >> cmd;

        if (cmd == "push_front") {
            cin >> x;
            mydeque.push_front(x);
        } else if (cmd == "push_back") {
            cin >> x;
            mydeque.push_back(x);
        } else if (cmd == "pop_front") {
            if (mydeque.empty()) {
                cout << -1 << endl;
            } else {
                cout << mydeque.front() << endl;
                mydeque.pop_front();
            }
        } else if (cmd == "pop_back") {
            if (mydeque.empty()) {
                cout << -1 << endl;
            } else {
                cout << mydeque.back() << endl;
                mydeque.pop_back();
            }
        } else if (cmd == "size") {
            cout << mydeque.size() << endl;
        } else if (cmd == "empty") {
            if (mydeque.empty()) {
                cout << 1 << endl;
            } else
                cout << 0 << endl;
        } else if (cmd == "front") {
            if (mydeque.empty()) {
                cout << -1 << endl;
            } else
                cout << mydeque.front() << endl;
        } else if (cmd == "back") {
            if (mydeque.empty()) {
                cout << -1 << endl;
            } else
                cout << mydeque.back() << endl;
        }
    }
    return 0;
}