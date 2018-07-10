//
// Created by sks10 on 2018-07-10.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


// 1. 가장 큰 숫자가 무조건 앞으로 *이미 맨 앞이 가장 큰 수인 경우 따로 처리
// 2. 가장 큰 수가 여러 개일 때 *위치 바꾸는 순서
// 3. 위치를 바꿀 필요가 없을 때
// 4. 위치 변경 횟수만 소진해야 할 때
void solve(string num, int times) {
    vector<int> num_array;
    // string으로 받은 숫자를 정수형으로 바꾸고 벡터에 저장
    for (char i : num) {
        num_array.push_back(int(i) - 48);
    }

    vector<int>::iterator high, low, cmp, end;
    vector<int> same_value;
    cmp = num_array.begin();
    end = num_array.end();
    bool is_same = false;
    while (times) {
        int temp = 0, index = 0;

        // 비교 반복자가 벡터의 끝에 도달한 경우 -> 3번, 4번의 경우
        if (cmp == end) {
            // 4. 동일한 큰 수 끼리 위치를 계속 바꾸면 되므로
            // break문으로 빠져나가면 됨
            high = max_element(num_array.begin(), num_array.end());
            for (auto it = num_array.begin(); it != num_array.end(); ++it) {
                if (*high == *it) {
                    same_value.push_back(distance(num_array.begin(), it));
                }
            }
            if (same_value.size() > 1)
                break;

            // 3. 동일한 큰 수가 없으므로
            // 1의자리와 10의자리의 숫자만 서로 변경하며 횟수 소진
            temp = *(num_array.end() - 1);
            *(num_array.end() - 1) = *(num_array.end() - 2);
            *(num_array.end() - 2) = temp;
            times--;
            continue;
        }

        high = max_element(cmp, end);
        // 제일 큰 숫자가 이미 맨 앞
        if (high == cmp) {
            cmp++;
            continue;
        }
        // 큰 숫자가 여러 개
        for (auto it = cmp; it != num_array.end(); ++it) {
            if (*high == *it) {
                // 큰 숫자들의 인덱스를 same_value 벡터에 넣고
                // 인덱스가 큰 숫자부터 위치 변경
                same_value.push_back(distance(num_array.begin(), it));
            }
        }
        if (same_value.size() > 1)
            is_same = true;

        // 1번과 2번 처리
        if (is_same) {
            // 2번 -> 뒷쪽에 위치한 큰 숫자와 가장 작은 수를 변경
            // 뒷쪽에 위치한 큰 숫자의 인덱스 가져오기
            index = same_value.back();
            same_value.pop_back();
            // 가장 작은 숫자와 위치 변경
            low = min_element(cmp, end);
            temp = *low;
            *low = num_array[index];
            num_array[index] = temp;
            // 가장 작은 수가 맨 뒤로 갔으므로 맨뒤는 비교할 필요가 없음
            end--;
        } else {
            // 1번 -> 큰 숫자를 맨 앞으로
            temp = *cmp;
            *cmp = *high;
            *high = temp;
            cmp++;
        }
        same_value.clear();
        times--;
    }
    for (int i : num_array) {
        cout << i;
    }
    cout << endl;
    num_array.clear();
}

int main() {
    int textCase;
    cin >> textCase;

    string num;
    int times;
    for (int i = 1; i <= textCase; ++i) {
        cin >> num >> times;
        cout << "#" << i << " ";
        solve(num, times);
    }
    return 0;
}