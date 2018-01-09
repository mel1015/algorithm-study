#include <stdio.h>
#include <stdlib.h>

int h[100001], t = 0;
int n;

void swap(int i, int j) {
    int temp = h[i];
    h[i] = h[j];
    h[j] = temp;
}

void push(int x) {
    h[++t] = x;
    for (int i = t; i > 1; i /= 2) {
        if (h[i] < h[i / 2]) swap(i, i / 2);
        else break;
    }
}

int pop() {
    int top = h[1];
    h[1] = h[t];
    t--;
    int i = 1;
    while (i * 2 <= t) {
        if (h[i] < h[i * 2] && h[i] < h[i * 2 + 1]) break;
        else if (h[i * 2] < h[i * 2 + 1]) {
            swap(i, i * 2);
            i = i * 2;
        } else {
            swap(i, i * 2 + 1);
            i = i * 2 + 1;
        }
    }
    return top;
}

int main() {
    int x;
    scanf("%d", &n);
    while (n--) {
        scanf("%d", &x);
        if (x == 0) {
            if (t == 0) printf("0\n");
            else printf("%d\n", pop());
        } else push(x);
    }
    return 0;
}