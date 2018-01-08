//
// Created by Han on 2018-01-08.
//
#include <stdio.h>
#include <string.h>

#pragma warning(disable:4996)
#define MAXSIZE 10000


struct R {
    int r;
} result[10000];

int main(void) {
    int n;
    scanf("%d", &n);
    int i;
    int stack[MAXSIZE];
    int innumber;
    int top = 0;
    int down = 0;
    int outnumber = 0;

    for (i = 0; i < n; i++) {
        char cmd[BUFSIZ];
        scanf("%s", &cmd);

        if (strcmp(cmd, "push") == 0) {
            scanf("%d", &innumber);
            stack[down] = innumber;
            down++;
        } else if (strcmp(cmd, "pop") == 0) {
            if (down <= 0 || down <= top) {
                result[outnumber].r = -1;
                outnumber++;
            } else {
                result[outnumber].r = stack[top];
                outnumber++;
                top++;

            }
        } else if (strcmp(cmd, "size") == 0) {
            result[outnumber].r = down - top;
            outnumber++;
        } else if (strcmp(cmd, "empty") == 0) {
            if (down > top) {
                result[outnumber].r = 0;
                outnumber++;
            } else {
                result[outnumber].r = 1;
                outnumber++;
            }
        } else if (strcmp(cmd, "front") == 0) {
            if (down > top) {
                result[outnumber].r = stack[top];
                outnumber++;
            } else {
                result[outnumber].r = -1;
                outnumber++;
            }
        } else if (strcmp(cmd, "back") == 0) {
            if (down > top) {
                result[outnumber].r = stack[down - 1];
                outnumber++;
            } else {
                result[outnumber].r = -1;
                outnumber++;
            }
        }

    }

    for (i = 0; i < outnumber; i++) {
        printf("%d\n", result[i].r);
    }

    return 0;
}
