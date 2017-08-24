//
// Created by sks10 on 2017-08-21.
//

#include <stdio.h>

void merge(int *arr, int left, int mid, int right) {
    int i, j, k;
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int L[n1], R[n2];

    for (int i = 0; i < n1; ++i) {
        L[i] = arr[left + i];
    }
    for (int j = 0; j < n2; ++j) {
        R[j] = arr[mid + 1 + j];
    }

    i = 0, j = 0, k = left;

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void merge_Sort(int *arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;

        merge_Sort(arr, left, mid);
        merge_Sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

int main() {

    int size, *arr;

    scanf("%d", &size);

    arr = new int[size];

    for (int i = 0; i < size; ++i) {
        scanf("%d", &arr[i]);
    }

    merge_Sort(arr, 0, size - 1);

    for (int j = 0; j < size; ++j) {
        printf("%d\n", arr[j]);
    }

    delete[] arr;
    return 0;
}