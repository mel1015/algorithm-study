//
// Created by sks10 on 2019-04-10.
//
#include<iostream>
#include<vector>

#define Up 3
#define Down 6
#define Front 5
#define Back 1
#define Left 2
#define Right 4

using namespace std;

char cube[7][4][4];
char sideColor[7] = {'.', 'o', 'g', 'w', 'b', 'r', 'y'};

void init() {
    for (int i = 1; i <= 6; i++) {
        for (int j = 1; j <= 3; j++) {
            for (int k = 1; k <= 3; k++) {
                cube[i][j][k] = sideColor[i];
            }
        }
    }
}

void turnUp() {
    for (int i = 1, j = 3; i <= 3; i++, j--) {
        int tmp = cube[5][1][i];
        cube[5][1][i] = cube[4][j][1];
        cube[4][j][1] = cube[1][3][j];
        cube[1][3][j] = cube[2][i][3];
        cube[2][i][3] = tmp;
    }
}

void turnFront() {
    for (int i = 1, j = 3; i <= 3; i++, j--) {
        int tmp = cube[6][1][i];
        cube[6][1][i] = cube[4][3][j];
        cube[4][3][j] = cube[3][3][j];
        cube[3][3][j] = cube[2][3][j];
        cube[2][3][j] = tmp;
    }
}

void turnRight() {
    for (int i = 1, j = 3; i <= 3; i++, j--) {
        int tmp = cube[6][i][3];
        cube[6][i][3] = cube[1][i][3];
        cube[1][i][3] = cube[3][i][3];
        cube[3][i][3] = cube[5][i][3];
        cube[5][i][3] = tmp;
    }
}

void turnLeft() {
    for (int i = 1, j = 3; i <= 3; i++, j--) {
        int tmp = cube[6][i][1];
        cube[6][i][1] = cube[5][i][1];
        cube[5][i][1] = cube[3][i][1];
        cube[3][i][1] = cube[1][i][1];
        cube[1][i][1] = tmp;
    }
}

void turnBack() {
    for (int i = 1, j = 3; i <= 3; i++, j--) {
        int tmp = cube[6][3][j];
        cube[6][3][j] = cube[2][1][i];
        cube[2][1][i] = cube[3][1][i];
        cube[3][1][i] = cube[4][1][i];
        cube[4][1][i] = tmp;
    }
}

void turnDown() {
    for (int i = 1, j = 3; i <= 3; i++, j--) {
        int tmp = cube[1][1][i];
        cube[1][1][i] = cube[4][i][3];
        cube[4][i][3] = cube[5][3][j];
        cube[5][3][j] = cube[2][j][1];
        cube[2][j][1] = tmp;
    }
}

void sideSetting(int side) {
    int tmp = cube[side][1][1];
    cube[side][1][1] = cube[side][3][1];
    cube[side][3][1] = cube[side][3][3];
    cube[side][3][3] = cube[side][1][3];
    cube[side][1][3] = tmp;

    int ttmp = cube[side][1][2];
    cube[side][1][2] = cube[side][2][1];
    cube[side][2][1] = cube[side][3][2];
    cube[side][3][2] = cube[side][2][3];
    cube[side][2][3] = ttmp;
}

void cubeMix(char side, char dir) {
    int count;
    if (side == 'U') {
        if (dir == '+') count = 1;
        else count = 3;

        for (int i = 0; i < count; i++) {
            turnUp();
            sideSetting(Up);
        }
    } else if (side == 'D') {
        if (dir == '+') count = 1;
        else count = 3;

        for (int i = 0; i < count; i++) {
            turnDown();
            sideSetting(Down);
        }
    } else if (side == 'F') {
        if (dir == '+') count = 1;
        else count = 3;

        for (int i = 0; i < count; i++) {
            turnFront();
            sideSetting(Front);
        }
    } else if (side == 'B') {
        if (dir == '+') count = 1;
        else count = 3;

        for (int i = 0; i < count; i++) {
            turnBack();
            sideSetting(Back);
        }
    } else if (side == 'L') {
        if (dir == '+') count = 1;
        else count = 3;

        for (int i = 0; i < count; i++) {
            turnLeft();
            sideSetting(Left);
        }
    } else if (side == 'R') {
        if (dir == '+') count = 1;
        else count = 3;

        for (int i = 0; i < count; i++) {
            turnRight();
            sideSetting(Right);
        }
    }
}


void printUp() {
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            cout << cube[Up][i][j];
        }
        cout << '\n';
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);

    int n;
    cin >> n;
    while(n--){
        int tc;
        cin >> tc;

        init();
        for (int i = 0; i < tc; i++) {
            char side, dir;
            cin >> side >> dir;
            cubeMix(side, dir);
        }
        printUp();
    }
    return 0;
}