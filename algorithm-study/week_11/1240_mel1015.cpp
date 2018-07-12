//
// Created by sks10 on 2018-07-11.
//
#include <iostream>
#include <vector>

using namespace std;

// 암호 코드 0 ~ 9
string digits[10] = {"0001101", "0011001", "0010011", "0111101", "0100011",
                     "0110001", "0101111", "0111011", "0110111", "0001011"};

vector<vector<char>> password;

int Decryption(int row, int col) {
    // 암호문 마지막 1의 위치에서 앞쪽의 56개의 숫자가 암호 코드
    int begin = col - 55;
    vector<int> realPass;

    while (begin < col) {
        // 암호 코드를 string형으로 만들어 놓았으므로
        // char형으로 입력받은 암호문을 7문자씩 잘라서 string형으로 변환
        string s(&password[row][begin], &password[row][begin + 7]);
        for (int i = 0; i < 10; ++i) {
            if (s == digits[i]) {
                // 암호 코드가 의미하는 숫자 저장
                realPass.push_back(i);
                break;
            }
        }
        // 다음 7문자
        begin += 7;
    }

    // 검증 코드 계산
    int validation = 0, result = 0;
    for (int i = 0; i < realPass.size(); ++i) {
        result += realPass[i];
        if ((i + 1) % 2 == 1) {
            validation += realPass[i] * 3;
        } else
            validation += realPass[i];
    }
    realPass.clear();

    if (validation % 10 == 0) {
        return result;
    } else
        return 0;
}

int main() {
    int testCase, row, col;
    cin >> testCase;

    for (int test = 1; test <= testCase; ++test) {
        cin >> row >> col;

        password.resize(row);
        for (int i = 0; i < row; ++i) {
            password[i].resize(col);
        }

        int passRow, passCol;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                cin >> password[i][j];
                if (password[i][j] == '1') {
                    // 암호문의 가장 마지막 1의 위치
                    passRow = i, passCol = j;
                }
            }
        }
        cout << "#" << test << " " << Decryption(passRow, passCol) << "\n";
        password.clear();
    }
    return 0;
};
