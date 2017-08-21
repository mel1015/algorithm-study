//
// Created by sks10 on 2017-08-21.
//

#include <cstdio>

#define MAX_NUM 10000

//전역변수 int,char,bool 은 모두 0으로 자동 초기화
//전역배열을 선언할 때 초기화 해주지 않으면 배열 전체가 자동으로 0으로 초기화
int count[MAX_NUM + 1];

// cin보단 scanf가 빠르고 scanf보다 fastscan이 10배 빠르다
// 시간제한이 있는 문제에서는 fastscan을 구현해서 쓰는게 효율적
void fastscan(int &x) {
    bool neg = false;
    register int c;
    x = 0;
    c = getchar();
    if (c == '-') {
        neg = true;
        c = getchar();
    }
    for (; (c > 47 && c < 58); c = getchar())
        x = (x << 1) + (x << 3) + c - 48;
    if (neg)
        x *= -1;
}


int main() {

    int size, num;

    fastscan(size);

    for (int i = 1; i <= size; ++i) {
        fastscan(num);
        count[num]++;
    }

    for (int j = 1; j <= MAX_NUM; ++j) {
        if (count[j] > 0) {
            for (int i = 0; i < count[j]; ++i) {
                printf("%d\n", j);
            }
        }
    }
    return 0;
}
