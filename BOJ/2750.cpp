//
// Created by sks10 on 2017-08-21.
//

#include <iostream>

using namespace std;

void swap(int *a, int *b) {
    *a = *b - *a;
    *b = *b - *a;
    *a = *a + *b;
}

void bubble_Sort(int *arr, int n) {
    for (int i = n; i > 0; --i) {
        for (int j = 1; j < i; ++j) {
            if (arr[j] < arr[j - 1])
                swap(&arr[j], &arr[j - 1]);
        }
    }
}

int main() {

    int cases;
    int *arr;

    cin >> cases;

    arr = new int[cases];

    for (int i = 0; i < cases; ++i) {
        cin >> arr[i];
    }
    bubble_Sort(arr, cases);

    for (int j = 0; j < cases; ++j) {
        cout << arr[j] << endl;
    }

    delete[] arr;

    return 0;
}