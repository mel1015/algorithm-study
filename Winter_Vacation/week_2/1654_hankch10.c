#include <stdio.h>

int n, k;
long long lan[1000002];
long long sum = 0;

int main() {
    scanf("%d %d", &k, &n);
    for (int i = 0; i < k; i++) {
        scanf("%lld", &lan[i]);
        sum += lan[i];
    }
    //랜선의 길이 동적 할당

    long long low = 0, high = sum / n, mid;
    int num=0;
    // high의 max값 지정
    for(int i=0;i<k;i++){
        num += lan[i]/high;
    }
    if (num >= n) {
        printf("%d", high);
    } //최대 길이로 나눈 개수가 목표 개수보다 크다면
        // 최대 길이가 나눌 수 있는 최대의 값
    else {
        //이분탐색 시작
        while (high > low + 1) {
            //조건값 low+1을 하지 않으면 low값이 200일 때 순환이 한번 더 돌고 값이 201일로 나오기 때문이다.
            mid = (low + high) / 2;
            int num = 0;
            //이분탐색 시작
            for (int i = 0; i < k; i++)
                num += lan[i] / mid;

            if (num >= n) low = mid;
            else high = mid;
        }

        printf("%lld\n", low);
    }
}