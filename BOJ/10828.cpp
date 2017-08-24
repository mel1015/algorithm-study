//
// Created by sks10 on 2017-08-15.
//
#include <iostream>
#include <stack>

using namespace std;

class MyStack {
private:
    stack<int> mystack;
    int element;
    string cmd;
public:
    MyStack() {
        this->element = 0;
    }

    ~MyStack() {

    }

    void get_Cmd() {
        cin >> this->cmd;

        if (this->cmd == "push") {
            cin >> this->element;
            this->mystack.push(element);
        } else if (this->cmd == "size") {
            cout << this->mystack.size() << endl;
        } else if (this->cmd == "empty") {
            cout << this->mystack.empty() << endl;
        } else if (this->cmd == "pop") {
            if (this->mystack.empty())
                cout << -1 << endl;
            else {
                cout << this->mystack.top() << endl;
                this->mystack.pop();
            }
        } else {
            if (this->mystack.empty())
                cout << -1 << endl;
            else
                cout << mystack.top() << endl;
        }
    }
};

int main() {
    MyStack *mystack = new MyStack();

    int cmd_num;
    cin >> cmd_num;
    cin.ignore(1, '\n');

    while (cmd_num > 0) {
        mystack->get_Cmd();
        cmd_num--;
    }

    delete mystack;

    return 0;
}

