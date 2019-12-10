//
// Created by sks10 on 2019-05-31.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>

#define endl "\n"
#define MAX 100

using namespace std;

int R, C, K, Answer = 0, maxRow = 3, maxCol = 3;
vector<vector<int>> map(MAX, vector<int>(MAX, -1));

void init() {
    cin >> R >> C >> K;
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            cin >> map[i][j];
        }
    }
}

bool cmp(pair<int, int> a, pair<int, int> b) {
    // pair<수, 등장 횟수>
    // 등장 횟수가 커지는 순으로 => 등장 횟수 오름차순
    // 등장 횟수가 같으면 수가 커니는 순으로
    if (a.second == b.second) {
        return a.first < b.first;
    } else {
        return a.second < b.second;
    }
}

// R 연산
void operationR() {
    // R 연산은 열의 개수가 변화
    // 현재 최대 행 크기와 열 크기를 가져오고
    // 열의 최대값을 갱신할 변수도 선언
    int row = maxRow;
    int col = maxCol;
    int maxSize = 0;
    // 행마다 연산
    for (int i = 0; i < row; ++i) {
        // 배열의 각 행에 들어있는 수의 등장 횟수 int 배열 numCount
        // 수와 등장 횟수를 묶는 pair 배열 countDigit
        // map을 갱신할 int 배열 temp
        vector<int> numCount(101);
        vector<pair<int, int>> countDigit;
        vector<int> temp;

        // 수의 등장 횟수와 수의 총 개수 세기
        int count = 0;
        for (int j = 0; j < col; ++j) {
            if (map[i][j]) {
                numCount[map[i][j]]++;
                count++;
            }
        }
        // 1부터 100까지 각 수가 몇번 나왔는지 pair 배열로 저장
        // 수의 총 개수만큼 저장이 끝나면 break;
        for (int k = 1; k <= MAX; ++k) {
            if (numCount[k]) {
                countDigit.emplace_back(k, numCount[k]);
                count -= numCount[k];
            }
            if (count == 0) break;
        }
        // 조건대로 정렬
        sort(countDigit.begin(), countDigit.end(), cmp);
        // pair 배열의 크기만큼, 총 개수가 100개가 안 넘을 때까지
        // temp 배열에 수와 등장 횟수 순으로 추가
        for (int l = 0; l < countDigit.size() && count <= MAX; ++l) {
            temp.push_back(countDigit[l].first);
            count++;
            temp.push_back(countDigit[l].second);
            count++;
        }
        // 행의 값 변경
        map[i] = temp;
        // 최대 열 개수 갱신
        maxSize = max(maxSize, (int) temp.size());
        maxCol = maxSize;
    }
    // 행마다 열의 개수가 최대 열의 개수보다 작으면 0 추가
    for (int i = 0; i < row; ++i) {
        while (map[i].size() != maxCol) {
            map[i].push_back(0);
        }
    }
}

void operationC() {
    int row = maxRow;
    int col = maxCol;
    int maxSize = 0;
    for (int i = 0; i < col; ++i) {
        vector<int> numCount(101);
        vector<pair<int, int>> countDigit;
        vector<int> temp;
        int count = 0;
        for (int j = 0; j < row; ++j) {
            if (map[j][i]) {
                numCount[map[j][i]]++;
                count++;
            }
        }
        for (int k = 1; k <= MAX; ++k) {
            if (numCount[k]) {
                countDigit.emplace_back(k, numCount[k]);
                count -= numCount[k];
            }
            if (count == 0) break;
        }
        sort(countDigit.begin(), countDigit.end(), cmp);
        for (int l = 0; l < countDigit.size() && count <= MAX; ++l) {
            temp.push_back(countDigit[l].first);
            count++;
            temp.push_back(countDigit[l].second);
            count++;
        }

        // temp 배열의 크기만큼 열의 값 변경
        for (int m = 0; m < temp.size(); ++m) {
            map[m][i] = temp[m];
        }
        // temp 배열보다 이전의 행의 크기가 크다면
        // 이전 연산 값이 들어가 있을 수 있으므로
        // 값을 -1로 초기화해 준다
        if (temp.size() < row) {
            for (int j = temp.size(); j < row; ++j) {
                map[j][i] = -1;
            }
        }
        maxSize = max(maxSize, (int) temp.size());
        maxRow = maxSize;
    }

    // 최대 행의 크기만큼 0 추가
    for (int i = 0; i < col; ++i) {
        for (int j = 0; j < maxRow; ++j) {
            if (map[j][i] == -1) {
                map[j][i] = 0;
            }
        }
    }
}

void printMap() {
    cout << Answer << endl;
    for (int i = 0; i < maxRow; ++i) {
        for (int j = 0; j < maxCol; ++j) {
            cout << setw(3) << map[i][j];
        }
        cout << endl;
    }
}

void solution() {
    while (map[R - 1][C - 1] != K) {
        if (maxRow >= maxCol) {
            operationR();
        } else {
            operationC();
        }
        Answer++;
//        printMap();
        if (Answer > MAX) {
            Answer = -1;
            break;
        }
    }
    cout << Answer << endl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    init();
    solution();

    return 0;
}