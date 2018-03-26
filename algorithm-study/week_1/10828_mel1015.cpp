//
// Created by sks10 on 2017-12-27.
//
#include <iostream>
#include <stack>

using namespace std;

// MyStack 클래스 선언
class MyStack {
private:
    stack<int> mystack;
    int element;
    string cmd;
public:
    // 생성자
    MyStack() {
        // 초기화
        this->element = 0;
    }

    // 소멸자
    ~MyStack() {

    }

    // 커맨드 입력에 따라 명령 수행
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
        } else if (this->cmd == "top") {
            if (this->mystack.empty())
                cout << -1 << endl;
            else
                cout << mystack.top() << endl;
        } else {
            cout << "커맨드 오류" << endl;
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

