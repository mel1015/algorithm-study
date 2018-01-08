//
// Created by Han on 2018-01-08.
//
#include <stdio.h>
#include <string.h>
#define MAXSIZE 10000


struct R {
    int r;
}result[10000];

int main(void) {
    int n;
    scanf("%d", &n);
    int i;
    int stack[MAXSIZE];
    int innumber;
    int top = 0;
    int outnumber = 0;

    for (i = 0; i < n; i++) {
        char cmd[BUFSIZ];
        scanf("%s", &cmd);

        if (strcmp(cmd, "push") == 0) {
            scanf("%d", &innumber);
            stack[top] = innumber;
            top++;
        }
        else if (strcmp(cmd, "pop") == 0) {
            if (top <= 0) {
                result[outnumber].r = -1;
                outnumber++;
            }
            else {
                result[outnumber].r = stack[top - 1];
                outnumber++;
                top--;
            }
        }
        else if (strcmp(cmd, "size") == 0) {
            result[outnumber].r = top;
            outnumber++;
        }
        else if (strcmp(cmd, "empty") == 0) {
            if (top > 0) {
                result[outnumber].r = 0;
                outnumber++;
            }
            else {
                result[outnumber].r = 1;
                outnumber++;
            }
        }
        else if(strcmp(cmd, "top") == 0) {
            if (top > 0) {
                result[outnumber].r = stack[top-1];
                outnumber++;

            }
            else {
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