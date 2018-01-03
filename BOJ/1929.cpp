//
// Created by sks10 on 2017-08-23.
//

#include <cstdio>


bool prime_number(int num) {
    if (num == 1) {
        return false;
    }
    for (int i = 2; i * i <= num; ++i) {
        if (num % i == 0)
            return false;
    }
    return true;
}

int main() {
    int M, N;

    scanf("%d%d", &M, &N);

    for (int i = M; i <= N; ++i) {
        if (prime_number(i))
            printf("%d\n", i);
    }
    return 0;
}
