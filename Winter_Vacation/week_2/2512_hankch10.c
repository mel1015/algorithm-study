#include <stdio.h>

int main() {
    int n, s_money[10002];
    int g_money;
    int low = 0, high = 0, mid;
    scanf("%d", &n);
    //배열 동적 할당 및 정렬
    for (int i = 0; i < n; i++) {
        scanf("%d", &s_money[i]);
        if (s_money[i] > high) high = s_money[i];
    }
    scanf("%d", &g_money);

    //이분 탐색 low = 0, high = 지방예산의 최대값
    //high >= low 이분탐색 종료
    while (high >= low) {
        mid = (low + high) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s_money[i] - mid > 0) sum += mid;
            else sum += s_money[i];
        }
        //특정 상한액을 구하는 계산
        if (sum > g_money) high = mid - 1;
        else low = mid + 1;
    }
    printf("%d\n", high);
}