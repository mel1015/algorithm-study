//
// Created by sks10 on 2018-07-12.
//
#include <iostream>
#include <vector>

using namespace std;

vector<int> password;

int main() {
    int n, data;
    for (int testCase = 1; testCase <= 10; ++testCase) {
        // 원본 암호문 입력
        cin >> n;
        for (int i = 0; i < n; ++i) {
            cin >> data;
            password.push_back(data);
        }

        // l(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다.
        // s는 덧붙일 숫자들, cmd는 명령어의 개수
        char l;
        int cmd, x, y, s;
        vector<int>::iterator it;
        cin >> cmd;
        for (int i = 0; i < cmd; ++i) {
            cin >> l >> x >> y;
            for (int j = 0; j < y; ++j) {
                cin >> s;
                // 암호문의 맨 앞
                it = password.begin();
                // 암호문의 맨 앞(it) + x번째 위치에 입력받은 암호(s) 삽입
                password.insert(it + x, s);
                x++;
            }
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
