//
// Created by sks10 on 2018-01-16.
//
#include <iostream>
#include <cstring>

using namespace std;

// 최댓값 설정
#define MAX_NUM 1000000000
#define MIN_NUM (-1000000000)

long long int stack[1001], push_num[100001];
char cmd[100001][5];

int main() {
    int index;
    while (true) {
        index = 0;
        while (true) {
            // 명령어를 입력 받는 while문
            cin >> cmd[index++];
            if (cmd[index - 1][0] == 'Q')
                return 0;
            else if (cmd[index - 1][0] == 'E')
                break;
            else if (strcmp(cmd[index - 1], "NUM") == 0) {
                cin >> push_num[index - 1];
            }
        }
        // 마지막 커맨드가 입력된 후 1이 증가됐으니 1감소 시킴
        index--;

        int n;
        cin >> n;
        // N개의 입력에 대해 프로그램을 수행
        while (n--) {
            int top = -1;
            long long int a, b;
            bool is_Error = false;
            // N개의 입력값 Vi
            cin >> a;
            // 스택에 저장
            stack[++top] = a;
            for (int i = 0; i < index && !is_Error; ++i) {
                if (strcmp(cmd[i], "NUM") == 0) {
                    // 스택에 명령어 NUM입력 시  입력 받은 숫자 저장
                    stack[++top] = push_num[i];
                } else if (strcmp(cmd[i], "POP") == 0) {
                    if (top < 0) {
                        // 에러 처리
                        is_Error = true;
                        continue;
                    } else {
                        top--;
                    }
                } else if (strcmp(cmd[i], "INV") == 0) {
                    if (top < 0) {
                        is_Error = true;
                        continue;
                    } else {
                        stack[top] *= (-1);
                    }
                } else if (strcmp(cmd[i], "DUP") == 0) {
                    if (top < 0) {
                        is_Error = true;
                        continue;
                    } else {
                        a = stack[top];
                        stack[++top] = a;
                    }
                } else if (strcmp(cmd[i], "SWP") == 0) {
                    if (top < 1) {
                        is_Error = true;
                        continue;
                    } else {
                        a = stack[top--];
                        b = stack[top--];
                        stack[++top] = a;
                        stack[++top] = b;
                    }
                } else if (strcmp(cmd[i], "ADD") == 0) {
                    if (top < 1) {
                        is_Error = true;
                        continue;
                    } else {
                        a = stack[top--];
                        b = stack[top--];
                        stack[++top] = a + b;
                        if (stack[top] > MAX_NUM || stack[top] < MIN_NUM) {
                            is_Error = true;
                        }
                    }
                } else if (strcmp(cmd[i], "SUB") == 0) {
                    if (top < 1) {
                        is_Error = true;
                        continue;
                    } else {
                        a = stack[top--];
                        b = stack[top--];
                        stack[++top] = b - a;
                        if (stack[top] > MAX_NUM || stack[top] < MIN_NUM) {
                            is_Error = true;
                        }
                    }
                } else if (strcmp(cmd[i], "MUL") == 0) {
                    if (top < 1) {
                        is_Error = true;
                        continue;
                    } else {
                        a = stack[top--];
                        b = stack[top--];
                        stack[++top] = a * b;
                        if (stack[top] > MAX_NUM || stack[top] < MIN_NUM) {
                            is_Error = true;
                        }
                    }
                } else if (strcmp(cmd[i], "DIV") == 0) {
                    if (top < 1) {
                        is_Error = true;
                        continue;
                    } else {
                        a = stack[top--];
                        if (a == 0) {
                            is_Error = true;
                            continue;
                        }
                        b = stack[top--];
                        // 나눗셈의 피연산자중 음수의 개수에 따라 부호 결정
                        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
                            stack[++top] = (abs(b) / abs(a)) * (-1);
                        } else {
                            stack[++top] = (abs(b) / abs(a));
                        }
                        if (stack[top] > MAX_NUM || stack[top] < MIN_NUM) {
                            is_Error = true;
                        }
                    }
                } else if (strcmp(cmd[i], "MOD") == 0) {
                    if (top < 1) {
                        is_Error = true;
                        continue;
                    } else {
                        a = stack[top--];
                        if (a == 0) {
                            is_Error = true;
                            continue;
                        }
                        b = stack[top--];
                        // 나머지의 부호는 피제수(b)의 부호와 동일
                        if (b < 0) {
                            stack[++top] = (abs(b) % abs(a)) * (-1);
                        } else {
                            stack[++top] = (abs(b) % abs(a));
                        }
                        if (stack[top] > MAX_NUM || stack[top] < MIN_NUM) {
                            is_Error = true;
                        }
                    }
                } else if (strcmp(cmd[i], "END") == 0) {
                    continue;
                } else {
                    is_Error = true;
                }
            }
            if (is_Error || top != 0) {
                cout << "ERROR" << endl;
            } else {
                cout << stack[0] << endl;
            }
        }
        cout << endl;
    }
}
