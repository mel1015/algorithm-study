//
// Created by Jeongho on 2017-12-30.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* queue; //큐 준비
int last=-1; //끝 초기화

void push(int num);
void pop();
void size();
void empty();
void front();
void back();

int main() {
    int command_count;
    scanf("%d",&command_count); //입력할 명령어 수 입력
    queue=(int*)malloc(sizeof(int)*command_count);//명령어 수에 따른 배열 동적 할당
    getchar(); // 출력 버퍼 비우기
    for(int i=0;i<command_count;i++){
        char command[50];
        char* result=NULL;
        char* value=NULL;
        scanf("%[^\n]s",command); //공백 포함하여 입력받기
        result=strtok(command," "); // 첫번째 공백까지 자르기
        if(strcmp(result,"push")==0){
            value=strtok(NULL," "); // 첫번째 공백뒤의 값의 주소를 value에 저장
            push(atoi(value));// atoi로 문자열 배열을 int로 변환
        }else if(strcmp(result,"pop")==0)
            pop();
        else if(strcmp(result,"size")==0)
            size();
        else if(strcmp(result,"empty")==0)
            empty();
        else if(strcmp(result,"size")==0)
            pop();
        else if(strcmp(result,"front")==0)
            front();
        else if(strcmp(result,"back")==0)
            back();
        getchar(); //출력 버퍼 비우기
    }
    free(queue); //동적 배열에 할당된 메모리 해제
    return 0;
}

void push(int num){
    queue[++last]=num; //큐에 값 넣기
}
void pop(){
    if(last<0){
        printf("%d\n",-1); //값이 없으면 -1 출력
    }else{
        printf("%d\n",queue[0]); //맨 앞의 값 출력
        if(last==0){
            last--; //큐에 값이 하나라면 last를 -1로 만든다
        }else{
            for(int i=0;i<last;i++)
                queue[i]=queue[i+1]; //큐에 담긴 값을 하나씩 당긴다
            last--; //큐의 갯수 감소
        }
    }
}
void size(){
    printf("%d\n",last+1); // 큐 담긴 갯수 출력
}
void empty(){
    if(last==-1)
        printf("1\n"); // 값이 비어있으면 1
    else
        printf("0\n"); // 비어있지 않으면 0
}
void front(){
    if(last==-1)
        printf("%d\n",-1); //큐에 값이 없으면 -1
    else
        printf("%d\n",queue[0]); //큐에 첫번째 값 출력
}
void back(){
    if(last==-1)
        printf("%d\n",-1); //큐에 값이 없으면 -1
    else
        printf("%d\n",queue[last]); //큐에 last 번째 값 출력
}