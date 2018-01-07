//
// Created by Jeongho on 2018-01-04.
//

#include <stdio.h>
#include <stdlib.h>

int heapSize=-1;
int* heapArray;
void insertHeap(int num);
void deleteHeap();

int main(){
    int command_count;
    scanf("%d",&command_count); //입력할 명령어 수 입력
    heapArray=(int*)malloc(sizeof(int)*command_count+1);//명령어 수에 따른 배열 동적 할당
    getchar(); // 출력 버퍼 비우기
    for(int i=0;i<command_count;i++){
        int num;
        scanf("%d",&num); //공백 포함하여 입력받기
        getchar(); //출력 버퍼 비우기
        if(num==0){
            deleteHeap();
        }else if(num>0){
            insertHeap(num);
        }
    }
    free(heapArray); //동적 배열에 할당된 메모리 해제
    return 0;
}

void insertHeap(int num){
    heapSize++; //힙 확장
    int i=heapSize;//임시로 확장한 장소를 가르킴
    //부모노드와 비교 하면서 값이 크면 부모노드와 자리를 바꿈
    //배열이 0부터시작하므로 (i-1)/2가 부모노드
    while( (i!=0) && (num<heapArray[(i-1)/2]) ){
        heapArray[i]=heapArray[(i-1)/2];
        i=(i-1)/2;
    }
    heapArray[i]=num;
}
void deleteHeap(){
    if(heapSize==-1) {
        printf("%d\n", 0);
        return;
    }
    printf("%d\n",heapArray[0]);
    int temp=heapArray[heapSize]; //임시로 배열의 끝값을 저장
    int root=0; //현재 루트노드
    int child=1; //자식노드
    while(child<=heapSize){
        if(child<heapSize){
            if(heapArray[child]>heapArray[child+1]) child=child+1; //자식노드 둘을 비교해서 작은것을 고름
        }
        if(temp<heapArray[child]) break; //만약 맨 끝값이 자식노드들보다 크다면 자리 확정
        heapArray[root]=heapArray[child];
        root=child; //다음으로 이동
        child=child*2+1; //다음 자식노드로 이동
    }
    heapArray[root]=temp; //위의 연산 수행후 나온 root에 배열 끝값 저장
    heapSize--; //힙 감소
}