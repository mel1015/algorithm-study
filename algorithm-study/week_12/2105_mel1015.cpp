//
// Created by sks10 on 2018-07-30.
//
#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> map;
vector<bool> visited;
int n, ans;

void clear_Visit() {
    visited.clear();
    visited.resize(101);
}

void init() {
    clear_Visit();
    ans = -1;
}

void go_Eat() {
    bool possible;
    int curi, curj;
    init(); // 방문여부, 최대값 초기화
    //  i, j :  출발지점 좌표
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            // a, b : 변의 길이
            for (int a = 1; j + a < n; a++) {
                for (int b = 1; j - b >= 0; b++) {
                    // 조건 : 2a+2b가 ans보다 클 경우
                    //        범위를 넘지 않을 경우
                    if (2 * a + 2 * b > ans && i + a + b < n) {
                        possible = true;    // 가능성 초기화
                        clear_Visit();
                        curi = i;
                        curj = j;
                        // 진행 방향 : 시계방향으로
                        // ↘
                        for (int n = 1; n <= a; n++) {
                            if (visited[map[curi + 1][curj + 1]]) {       // 방문 o
                                possible = false;
                                break;
                            } else {                              // 방문 x
                                curi++;     // 현재 위치 이동
                                curj++;
                                visited[map[curi][curj]] = true;
                            }
                        }
                        if (!possible) continue;

                        // ↙
                        for (int n = 1; n <= b; n++) {
                            if (visited[map[curi + 1][curj - 1]]) {       // 방문 o
                                possible = false;
                                break;
                            } else {                              // 방문 x
                                curi++;     // 현재 위치 이동
                                curj--;
                                visited[map[curi][curj]] = true;
                            }
                        }
                        if (!possible) continue;

                        // ↖
                        for (int n = 1; n <= a; n++) {
                            if (visited[map[curi - 1][curj - 1]]) {       // 방문 o
                                possible = false;
                                break;
                            } else {                              // 방문 x
                                curi--;     // 현재 위치 이동
                                curj--;
                                visited[map[curi][curj]] = true;
                            }
                        }
                        if (!possible) continue;

                        // ↗
                        for (int n = 1; n <= b; n++) {
                            if (visited[map[curi - 1][curj + 1]]) {       // 방문 o
                                possible = false;
                                break;
                            } else {                              // 방문 x
                                curi--;     // 현재 위치 이동
                                curj++;
                                visited[map[curi][curj]] = true;
                            }
                        }
                        if (!possible) continue;
                        // 경로 완성
                        ans = 2 * a + 2 * b;
                    }
                }
            }
        }
    }
}

int main() {
    int testCase;
    cin >> testCase;
    for (int tc = 1; tc <= testCase; ++tc) {
        cin >> n;
        map.resize(n);
        for (int i = 0; i < n; ++i) {
            map[i].resize(n);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cin >> map[i][j];
            }
        }
        go_Eat();
        cout << "#" << tc << " " << ans << "\n";
        map.clear();
    }
    return 0;
}
