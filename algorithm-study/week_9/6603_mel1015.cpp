//
// Created by sks10 on 2018-05-15.
//
#include <iostream>
#include <algorithm>

using namespace std;

int a[50];
int s[50];

// next_permutation(Iterator first, Iterator last);
// 1-2-3-4  =>  1-2-4-3 으로 바뀌고 true를 반환
// 현재의 수열에서 다음 순열을 구하고 true를 반환
// 다음 순열이 없다면 false 반환
int main() {
    while (true) {
        int k;
        scanf("%d", &k);
        if (k == 0) break;

        for (int i = 0; i < k; i++) {
            scanf("%d", &s[i]);
            // 순열을 만들 a배열 초기화
            if (i < 6)
                a[i] = 0;
            else
                a[i] = 1;
        }
        do {
            for (int i = 0; i < k; i++) {
                // a 배열에서 값이 0인 인덱스만 출력
                if (a[i] == 0)
                    cout << s[i] << " ";
            }
            cout << endl;
        } while (next_permutation(a, a + k));
        cout << endl;
    }
    return 0;
}
