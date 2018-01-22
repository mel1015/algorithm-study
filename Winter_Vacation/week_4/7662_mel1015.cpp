//
// Created by sks10 on 2018-01-22.
//
#include <iostream>
#include <map>

using namespace std;

int main() {
    int t, q;

    cin >> t;

    while (t--) {
        map<long long, long long> mymap;

        cin >> q;

        for (int i = 0; i < q; i++) {
            char cmd;
            long long data;

            cin >> cmd >> data;

            if (cmd == 'I')
                if (mymap.find(data) == mymap.end()) {
                    // 맵의 key(data)가 없을 때
                    // end 반복자 반환
                    // key(data)의 value를 0으로
                    mymap[data] = 0;
                } else {
                    // 맵의 key(data)가 있을 때
                    // key의 value를 1증가(중복 횟수)
                    mymap[data]++;
                }
            else if (cmd == 'D' && !mymap.empty()) {
                map<long long, long long>::iterator it;
                if (data == 1) {
                    // map은 key를 대상으로 자동으로 정렬하므로 마지막 값이 가장 큰 값
                    // mymap.end()는 맵의 마지막 원소의 다음의(빈 공간) 반복자를 반환
                    // 선 감소 연산자를 이용해 마지막 원소를 가르키는 반복자를 가져옴
                    it = --mymap.end();
                } else {
                    // 시작 부분이 가장 작은 값
                    it = mymap.begin();
                }

                if (it->second == 0) {
                    // 반복자가 가르키는 key의 value가 0이면
                    // 같은 값이 중복으로 나온적이 없으므로
                    // 데이터를 삭제
                    mymap.erase(it);
                } else {
                    // 중복으로 값이 나왔으므로 중복 횟수를 1감소
                    it->second--;
                }
            }
        }
        if (mymap.empty())
            cout << "EMPTY" << endl;
        else
            cout << (--mymap.end())->first << " " << mymap.begin()->first << endl;
    }
    return 0;
}