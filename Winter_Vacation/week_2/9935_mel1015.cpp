//
// Created by sks10 on 2018-01-07.
//
#include <iostream>
#include <cstring>
#include <vector>

using namespace std;

char Text[1000001];
char Bomb[37];

int main() {

    cin >> Text >> Bomb;

    // 캐릭터형 백터 선언
    vector<char> myvector;

    // 주어진 문자열과 폭발 문자열 길이 저장
    int str_length = strlen(Text);
    int bomb_length = strlen(Bomb);

    for (int i = 0; i < str_length; ++i) {
        // 벡터에 문자 하나씩 저장
        myvector.push_back(Text[i]);
        int count = 0;
        // 벡터에 폭발 문자열이 들어왔는지 확인
        // 폭발 문자열의 마지막 문자가 벡터에 들어오면
        // 현재 인덱스에서 폭발 문자열의 크기만큼 벡터의 앞 내용을 확인
        if (myvector.size() >= bomb_length && Text[i] == Bomb[bomb_length-1]) {
            int index = myvector.size();
            for (int j = 0; j < bomb_length; ++j) {
                if (myvector.at(index - bomb_length + j) == Bomb[j]) {
                    count++;
                }
            }
            if (count == bomb_length) {
                for (int j = 0; j < bomb_length; ++j) {
                    myvector.pop_back();
                }
            }
        }
    }

    if (myvector.empty()) {
        cout << "FRULA" << endl;
    } else {
        for (int i = 0; i < myvector.size(); ++i) {
            cout << myvector[i];
        }
    }

    return 0;
}