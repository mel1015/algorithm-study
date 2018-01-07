#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* stack; //배열 준비
int top=-1; // 초기값

void push(int num);
void pop();
void size_();
void empty();
void top_();

int main() {
    int command_count;
    scanf("%d",&command_count); //입력할 명령어 수 입력
    stack=(int*)malloc(sizeof(int)*command_count);//명령어 수에 따른 배열 동적 할당
    getchar(); // 출력 버퍼 비우기
    for(int i=0;i<command_count;i++){
        char command[100];
        char* result=NULL;
        char* value=NULL;
        scanf("%[^\n]s",command); //공백 포함하여 입력받기
        result=strtok(command," "); // 첫번째 공백까지 자르기
        if(strcmp(result,"push")==0){
            value=strtok(NULL," "); // 첫번째 공백뒤의 값의 주소를 value에 저장
            push(atoi(value));// atoi로 문자열 배열을 int로 변환
        }else if(strcmp(result,"top")==0)
            top_();
        else if(strcmp(result,"size")==0)
            size_();
        else if(strcmp(result,"empty")==0)
            empty();
        else if(strcmp(result,"pop")==0)
            pop();
        getchar(); //출력 버퍼 비우기
    }
    free(stack); //동적 배열에 할당된 메모리 해제
    return 0;
}

void push(int num){
    stack[++top]=num; // top 값 증가 후 top 번째 값 입력
}
void pop(){
    if(top!=-1)
        printf("%d\n",stack[top--]); //top 번째 스택 값 출력후 top 값 감소
    else
        printf("%d\n",-1); // 값이 없을 경우 -1 출력
}
void size_(){
    printf("%d\n",top+1); // top 값 출력
}
void empty(){
    if(top==-1)
        printf("1\n"); // 값이 비어있으면 1
    else
        printf("0\n"); // 비어있지 않으면 0

}
void top_(){
    if(top==-1)
        printf("%d\n",-1); //스택에 값이 없으면 -1
    else
        printf("%d\n",stack[top]); //스택에 top 번째 값 출력
}