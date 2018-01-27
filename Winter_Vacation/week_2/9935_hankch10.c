#include <stdio.h>
#include <string.h>

char origin[1000002];
char stack[1000002];
char boom[37];
int a, b, index = 0;

int main(void) {
    scanf("%s", origin);
    scanf("%s", boom);
    // 주어진 문자열과 폭발 문자열 길이 저장

    a = (int) strlen(origin);
    b = (int) strlen(boom);

    for (int i = 0; i < a; i++) {
        stack[index] = origin[i];
        index++;
        if (a >= b && stack[index - 1] == boom[b - 1]) {
            if (strncmp(&stack[index - b], boom, b) == 0) {
                for (int j = 0; j < b; ++j) {
                    index--;
                }
            }
        }
    }
    // 스택에 폭발 문자열이 들어왔는지 확인
    // 폭발 문자열의 마지막 문자가 스택에 들어오면
    // 현재 인덱스에서 폭발 문자열의 크기만큼 스택의 앞 내용을 확인

    if (index > 0) {
        for (int k = 0; k < index; ++k) {
            printf("%c", stack[k]);
        }
    } else {
        printf("FRULA");
    }
    // 인덱스값을 확인하고 출력

    return 0;
}


