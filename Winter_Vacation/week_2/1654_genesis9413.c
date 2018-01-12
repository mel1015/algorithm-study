//
// Created by Jeongho on 2018-01-09.
//

#include <stdio.h>
#include <stdlib.h>

int compare (void *first, void *second);
int array_size;
int* array;
int total_count;
int condition(long long length);
long long findLength(long long min,long long max);

int main(){
    scanf("%d",&array_size); //입력할 명령어 수 입력
    array=(int*)malloc(sizeof(int)*(array_size));
    scanf("%d",&total_count);
    int max;

    for(int i=0;i<array_size;i++){
        scanf("%d",&array[i]);
        if(i!=0 && max<array[i]){
            max=array[i];
        }
    }

    qsort(array, array_size, sizeof(int), compare); //정렬

    long long max_length = findLength(0,max);
    printf("%lld",max_length);
}

// 오름차순
int compare (void *first, void *second)
{
    if (*(int*)first > *(int*)second)
        return 1;
    else if (*(int*)first < *(int*)second)
        return -1;
    else
        return 0;
}

long long findLength(long long min,long long max){
    long long middle=((min+max)/2);
    if(condition(middle)==1){
//        printf("true min : %lld max : %lld\n",min,max);
        if(middle==min) {
            return middle;
        }
        findLength(middle,max+1); //값을 조금 넓게 잡아주는것이 핵심
    }else{
//        printf("false min : %lld max : %lld\n",min,max);
        findLength(min,middle);
    }
}

int condition(long long length){
    int count=0;
    for(int i=0;i<array_size;i++){
        count+=array[i]/(int)length;
    }
    if(count>=total_count){
//        printf("length : %lld true : %d\n",length,count);
        return 1;
    }
    else{
//        printf("length : %lld false : %d\n",length,count);
        return 0;
    }
}