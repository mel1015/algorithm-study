//
// Created by sks10 on 2019-05-22.
//
#include <iostream>
#include <vector>
#include <algorithm>

#define endl "\n"

using namespace std;

struct shark {
    // 상어 구조체
    // 좌표(r,c), 속도, 방향, 크기
    int r;
    int c;
    int speed;
    // dir => 1 위, 2 아래, 3 우, 4 좌
    int dir;
    int size;
};

int R, C, M, answer = 0;

vector<shark> sharks;
vector<vector<vector<shark>>> map;

int dr[] = {0, -1, 1, 0, 0};
int dc[] = {0, 0, 0, 1, -1};

void init() {
    cin >> R >> C >> M;
    map.resize(R);
    for (int i = 0; i < R; ++i) {
        map[i].resize(C);
    }
    for (int i = 0; i < M; ++i) {
        int r, c, s, d, z;
        shark temp;
        cin >> r >> c >> s >> d >> z;
        temp = {r - 1, c - 1, s, d, z};
        sharks.push_back(temp);
        map[r - 1][c - 1].push_back(temp);
    }
}

// 행 비교
bool cmpRow(shark a, shark b) {
    // 행이 작은 상어부터 잡혀야하므로
    return a.r < b.r;
}

// 사이즈 비교
bool cmpSize(shark a, shark b) {
    return a.size > b.size;
}

// 상어 지우기
void sharkErase(shark a) {
    for (int i = 0; i < sharks.size(); ++i) {
        if (a.size == sharks[i].size) {
            sharks.erase(sharks.begin() + i);
            return;
        }
    }
}

// 상어 이동
void sharkMove() {
    vector<vector<vector<shark>>> temp;
    temp.resize(R);
    for (int i = 0; i < R; ++i) {
        temp[i].resize(C);
    }
    // 상어 이동
    for (int i = 0; i < sharks.size(); ++i) {
        int nr = sharks[i].r, nc = sharks[i].c;
        int d = sharks[i].dir;
        if (d == 1 || d == 2) {
            for (int j = 0; j < sharks[i].speed; ++j) {
                nr += dr[d];
                nc += dc[d];
                if (nr < 0) {
                    d = 2;
                    nr += 2;
                }
                if (nr >= R) {
                    d = 1;
                    nr -= 2;
                }
            }
        } else if (d == 3 || d == 4) {
            for (int j = 0; j < sharks[i].speed; ++j) {
                nr += dr[d];
                nc += dc[d];
                if (nc < 0) {
                    d = 3;
                    nc += 2;
                }
                if (nc >= C) {
                    d = 4;
                    nc -= 2;
                }
            }
        }
        sharks[i].r = nr;
        sharks[i].c = nc;
        sharks[i].dir = d;
        temp[nr][nc].push_back(sharks[i]);
    }
    map = temp;
}

// 상어끼리 위치가 겹치게 되면 사이즈가 큰 상어만 남고 다 지움
void sharkKill() {
    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            if (map[i][j].size() > 1) {
                sort(map[i][j].begin(), map[i][j].end(), cmpSize);
                for (int k = 1; k < map[i][j].size(); ++k) {
                    sharkErase(map[i][j][k]);
                }
                map[i][j].erase(map[i][j].begin() + 1, map[i][j].end());
            }
        }
    }
}

void printMap() {
    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            cout << map[i][j][0].size << " ";
        }
        cout << endl;
    }
    cout << answer << endl;

}

void solution() {
    // 낚시왕은 1초마다 한 열씩 이동
    for (int col = 0; col < C; ++col) {
        // 잡을 수 있는 상어들을 저장할 배열
        vector<shark> catchShark;
        bool canCatch = false;
        for (int i = 0; i < sharks.size(); ++i) {
            if (sharks[i].c == col) {
                // 낚시왕이 위치한 열의 모든 상어는
                // 잡힐 수 있는 상어이므로 일단 저장
                catchShark.push_back(sharks[i]);
                canCatch = true;
            }
        }
        if (canCatch) {
            // 낚시왕과 가까운(행이 작은) 상어 순으로 정렬
            // 행이 가장 작은 상어를 잡고 상어 목록에서 지움
            sort(catchShark.begin(), catchShark.end(), cmpRow);
            answer += catchShark[0].size;
            sharkErase(catchShark[0]);
        }
        sharkMove();
        sharkKill();
//        printMap();
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    init();
    solution();
    cout << answer << endl;

    return 0;
}
