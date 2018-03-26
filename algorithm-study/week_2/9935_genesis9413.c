//
// Created by Jeongho on 2018-01-10.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int top=-1;
char* stack;
char input[1000001];
char boom[36];
int inputLen;
int boomLen;

void push(char input);
void pop();

int main(){
    scanf("%s",input);
    scanf("%s",boom);
    inputLen=strlen(input);
    boomLen=strlen(boom);
    stack=(char*)malloc(sizeof(char)*inputLen+1);
    for(int i=0;i<inputLen;i++){
        push(input[i]);
        if(input[i]==boom[boomLen-1]){
            int count=0;
            for(int j=0;j<boomLen;j++){
                if(top-j>=0 && stack[top-j]==boom[boomLen-1-j]) count++;
            }
            if(count==boomLen){
                for(int j=0;j<boomLen;j++){
                    pop();
                }
            }
        }
    }
    if(top==-1){
        printf("FRULA");
    }else{
        for(int i=0;i<=top;i++){
            printf("%c",stack[i]);
        }
    }
}

void push(char input){
    stack[++top]=input;
}
void pop(){
    if(top!=-1){
        top--;
    }
}