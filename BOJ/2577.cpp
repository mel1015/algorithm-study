//
// Created by sks10 on 2017-09-09.
//

#include <iostream>
#include <cstring>

using namespace std;


int main() {

    int a, b, c;
    int result;
    char arr[1000];
    int count[10] = {0,};

    cin >> a >> b >> c;
    result = a * b * c;

    int size = sprintf(arr, "%d", result);
    // sprintf (문자열이 저장될 버퍼의 포인터, 문자열 형식, 크기);
    // sprintf : 형식이 지정된 데이터를 문자열에 쓴다.
    // 반환 값은 쓰여진 총 문자 수.

    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < 10; ++j) {
            if (arr[i] == j + 48) {
                count[j]++;
            }
        }
    }

    for (int k = 0; k < 10; ++k) {
        cout << count[k] << endl;
    }

    return 0;
}