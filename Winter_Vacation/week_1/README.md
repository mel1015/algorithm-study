> 문제를 풀면서 알게된 팁 공유

## To-Do List
- 알고리즘 문제집 [자료구조](https://www.acmicpc.net/workbook/view/1442)
    - 1주차 : 스택 / 큐 / 최대 힙 / 최소 힙 

## Tip

- 신광식
    - [10828번](https://github.com/mel1015/algorithm-study/blob/10845/Winter_Vacation/week_1/10828_mel1015.cpp)
        - switch ~ case 문의 판별 변수에는 정수 자료형만 사용 가능하므로 switch문으로 구현 불가<BR>
        단, 문자 자료형(char)도 정수 자료형이므로 사용 가능 
        - C++의 `string :: operator == ()` 와 `string :: compare ()` 는 동일하다.     
    - [10845번](https://github.com/mel1015/algorithm-study/blob/10845/Winter_Vacation/week_1/10845_mel1015.cpp)
        - [C++ STL](http://www.cplusplus.com/reference/stl/)을 사용하면 편하다.
    - [11279번](https://github.com/mel1015/algorithm-study/blob/11279/Winter_Vacation/week_1/11279_mel1015.cpp), 
    [1927번](https://github.com/mel1015/algorithm-study/blob/1927/Winter_Vacation/week_1/1927_mel1015.cpp)
        - C++ STL의 [priority_queue](http://www.cplusplus.com/reference/queue/priority_queue/) 사용
        - `priority_queue<int> pq;` 는 `priority_queue<int, vector<int>, less<int> > pq;`와 동일하다.
        - priority_queue는 push 연산은 큐와 같지만 pop을 할 때 가장 큰 값이 빠져나온다.
        - `priority_queue<int, vector<int>, less<int> > pq;`에서 두 번째 형 변수는 연동 컨테이너.<br>
            값의 저장 방식이 해당 자료구조와 동일하다.
        - `priority_queue<int, vector<int>, less<int> > pq;`에서 세 번째 형 변수는g 비교에 사용할 연산.<br>
            less이면 큰 값 부터 빠져나오고 greater이면 작은 값 부터 빠져나온다.
- 장정호
    - [10828번](https://github.com/mel1015/algorithm-study/blob/master/Winter_Vacation/week_1/10828_genesis9413.c)
        - scanf("%[^\n]s",&variable)은 공백 포함하여 내용을 입력 받을 수 있습니다.
        - scanf는 입력버퍼가 비어 있을 경우, 입력을 받을 수 있는 상태로 전환합니다. <BR>반복문에서 scanf를 연달아 사용할 경우, 첫번째는 작동하지만 다음 scanf는 작동하지 않습니다. 따라서 getchar()를 통해 중간에 입력 버퍼를 비워줘야, 다음 scanf가 입력받을 수 있는 상태로 전환됩니다.
        - scanf로 문자열 입력을 받았으므로, 정수라고 하더라도 문자열로 인식됩니다. 따라서 atoi(ascii to int) 함수로 문자열을 정수로 변환해줍니다.
    - [11279번]()
        - 힙을 구현할때 배열을 0부터 시작하였으므로 현재 위치를 i라고 하였을때, 부모 노드는 (i-1)/2, 자식 노드는 왼쪽 2*i+1, 오른쪽 2*i+2 입니다.
## Progress
- 신광식 : 10828, 10845, 11279, 1927
- 한경철 : 10828, 10845
- 장정호 : 10828, 10845, 11279, 1927
- 최현석 : 10828, 10845