#include <stdio.h>

int main() {
    int n, s_money[10002];
    int g_money;
    int low = 0, high = 0, mid;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &s_money[i]);
        if (s_money[i] > high) high = s_money[i];
    }
    scanf("%d", &g_money);

    while (high >= low) {
        mid = (low + high) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s_money[i] - mid > 0) sum += mid;
            else sum += s_money[i];
        }
        if (sum > g_money) high = mid - 1;
        else low = mid + 1;
    }
    printf("%d\n", high);
}