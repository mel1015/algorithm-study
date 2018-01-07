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
        - `priority_queue<int, vector<int>, less<int> > pq;`에서 세 번째 형 변수는 비교에 사용할 연산.<br>
            less이면 큰 값 부터 빠져나오고 greater이면 작은 값 부터 빠져나온다.
        
## Progress
- 신광식 : 10828, 10845, 11279, 1927