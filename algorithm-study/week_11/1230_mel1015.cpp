//
// Created by sks10 on 2018-07-14.
//
#include <iostream>
#include <vector>

using namespace std;

vector<int> password;

void password_Insert(int x, int y) {
    int s;
    vector<int>::iterator it;
    for (int i = 0; i < y; ++i) {
        cin >> s;
        // 암호문의 맨 앞
        it = password.begin();
        // 암호문의 맨 앞(it) + x번째 위치에 입력받은 암호(s) 삽입
        password.insert(it + x, s);
        x++;
    }
}

void password_Delete(int x, int y) {
    vector<int>::iterator it;
    it = password.begin();
    password.erase(it + x, it + x + y);
}

void password_Add(int y) {
    int s;
    for (int i = 0; i < y; ++i) {
        cin >> s;
        password.push_back(s);
    }
}

void get_Command() {
    char cmd;
    int x, y;
    cin >> cmd;
    switch (cmd) {
        case 'I':
            cin >> x >> y;
            password_Insert(x, y);
            break;
        case 'D':
            cin >> x >> y;
            password_Delete(x, y);
            break;
        case 'A':
            cin >> y;
            password_Add(y);
            break;
        default:
            return;
    }
}

int main() {
    int n, data;
    for (int testCase = 1; testCase <= 10; ++testCase) {
        // 원본 암호문 입력
        cin >> n;
        for (int i = 0; i < n; ++i) {
            cin >> data;
            password.push_back(data);
        }

        int cmd;
        cin >> cmd;
        for (int i = 0; i < cmd; ++i) {
            get_Command();
        }

        cout << "#" << testCase << " ";
        for (int k = 0; k < 10; ++k) {
            cout << password[k] << " ";
        }
        cout << endl;
        password.clear();
    }
    return 0;
}
