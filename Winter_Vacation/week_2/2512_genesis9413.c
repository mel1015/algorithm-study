//
// Created by Jeongho on 2018-01-05.
//

#include <stdio.h>
#include <stdlib.h>

int budget;
int num_count;
int* array;
int compare (void *first, void *second);
int findLimit(int min,int max);
int condition(int limit);

int main(){
    scanf("%d",&num_count); //입력할 명령어 수 입력
    array=(int*)malloc(sizeof(int)*(num_count));
    int max=0;
    for(int i=0;i<num_count;i++){
        scanf("%d",&array[i]);
        max+=array[i];
    }
    scanf("%d",&budget);
    qsort(array, num_count, sizeof(int), compare); //정렬
    //총 요청이 예산보다 적을때
    if(max<=budget){
        printf("%d",array[num_count-1]); //최대 요청 금액 출력
    }else{
        int limit;
        //sort한 array의 최대값이 budget보다 클때 최대값은 budget
        if(array[num_count-1]>budget){
            limit=findLimit(0,budget);
        }else{
            limit=findLimit(0,array[num_count-1]);
        }
        printf("%d",limit);
    }
    return 0;
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

int findLimit(int min,int max){
    int middle=(min+max)/2;
//    printf("min %d max %d middle %d\n",min,max,middle);
    if(condition(middle)==1){
        if(max-min==1){
            return middle;
        }
        findLimit(middle,max);
    }else{
        findLimit(min,middle);
    }

}

int condition(int limit){
//    printf("condition : %d ",limit);
    int max=0;
    for(int i=0; i<num_count;i++){
        if(array[i]>limit){
            max+=limit;
        }else{
            max+=array[i];
        }
    }
//    printf("condition total max : %d\n",max);
    if(max<=budget)
        return 1;
    else
        return 0;
}