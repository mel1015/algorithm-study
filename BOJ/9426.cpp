//
// Created by sks10 on 2017-08-21.
//

#include <iostream>
#include <algorithm>

using namespace std;

int partition(int *input, int p, int r) {
    int pivot = input[r];

    while (p < r) {
        while (input[p] < pivot)
            p++;

        while (input[r] > pivot)
            r--;

        if (input[p] == input[r])
            p++;
        else if (p < r) {
            int tmp = input[p];
            input[p] = input[r];
            input[r] = tmp;
        }
    }

    return r;
}

int quick_select(int *input, int p, int r, int k) {
    if (p == r) return input[p];
    int j = partition(input, p, r);
    int length = j - p + 1;
    if (length == k) return input[j];
    else if (k < length) return quick_select(input, p, j - 1, k);
    else return quick_select(input, j + 1, r, k - length);
}

int main() {
    int N, K, nth, *arr, *subarr;
    long long int sum = 0;

    cin >> N >> K;

    arr = new int[N];
    subarr = new int[K];

    nth = (K + 1) / 2;

    for (int i = 0; i < N; ++i) {
        cin >> arr[i];
    }

    if (K == 1) {
        for (int i = 0; i < N; ++i) {
            sum += arr[i];
        }
        cout << sum << endl;
    } else if (K == 2) {
        for (int i = 1; i <= N; ++i) {
            sum += max(arr[i], arr[i - 1]);
        }
        cout << sum << endl;
    } else {
        for (int i = 0; i <= N - K; ++i) {
            for (int j = 0; j < K; ++j) {
                subarr[j] = arr[i + j];
            }
//            sort(subarr, subarr + K);
//            sum += subarr[((K + 1) / 2) - 1];
            sum += quick_select(subarr, 0, K - 1, nth);
        }
        cout << sum << endl;
    }
    delete[] arr;
    delete[] subarr;

    return 0;
}