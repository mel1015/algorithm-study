> 문제를 풀면서 알게된 팁 공유

## To-Do List
- 알고리즘 문제집 [자료구조](https://www.acmicpc.net/workbook/view/1442)
    - 3주차 : [트리](https://www.acmicpc.net/problem/1068) / 
    [트리 순회](https://www.acmicpc.net/problem/1991) / 
    [고스택](https://www.acmicpc.net/problem/3425) / 
    [스택 수열](https://www.acmicpc.net/problem/1874)

## Tip
- 신광식
    - [1068번](https://github.com/mel1015/algorithm-study/blob/1068/Winter_Vacation/week_3/1068_mel1015.cpp)
        - [깊이 우선 탐색](http://blog.eairship.kr/268)을 이용해 시작 노드에서 리프까지 내려가서 리프의 총 개수를 
        확인 하고,<br> leaf 배열에 자신에게 연결 된 총 리프 수를 저장한다.
    - [1991번](https://github.com/mel1015/algorithm-study/blob/1991/Winter_Vacation/week_3/1991_mel1015.cpp)
        - 클래스를 활용하여 노드와 트리를 구현함.
        - 객체 배열 동적 할당은 `클래스명 *배열명 = new 클래스명[크기];` 이다.<br>
        ex) `Node *node_arr = new Node[10]`;
        - 동적 할당을 했으면 반드시 반환을 해주어야 한다. `delete[] 배열명;`
    - [1874번](https://github.com/mel1015/algorithm-study/tree/1874/Winter_Vacation/week_3)
        - Fast I/O
            - cin보단 scanf가 빠르고 scanf보다 fastscan이 10배 빠르다
            - 시간제한이 있는 문제에서는 fastscan을 구현해서 쓰는게 효율적
            - 입력 속도
                - using cin :- time= 1.30
                - using scanf :- time= 0.52
                - using cin with std::ios::sync_with _stdio(false); :- time = 0.44
                - using cin with std::ios::sync_with _stdio(false); cin.tie(NULL); :- time=0.41
                - using getchar :- time = 0.34
                - using getchar_unlocked :- time = 0.15 
                <br><br>
            ```cpp
            void fastscan(int &number)
            {
                //variable to indicate sign of input number
                bool negative = false;
                register int c;
               
                number = 0;
               
                // extract current character from buffer
                c = getchar();
                if (c=='-')
                {
                    // number is negative
                    negative = true;
               
                    // extract the next character from the buffer
                    c = getchar();
                }
                   
                // Keep on extracting characters if they are integers
                // i.e ASCII Value lies from '0'(48) to '9' (57)
                for (; (c>47 && c<58); c=getchar())
                    number = number *10 + c - 48;
                        
                // if scanned input has a negative sign, negate the
                // value of the input number
                if (negative)
                    number *= -1;
            }
                  
            // Function Call
            fastscan(number);
            ```
        - **알고리즘만 잘 짜면 cin으로도 시간 초과 발생할 일이 없다.**
- 최현석
    - [3425번]
        - 문제에 조건이 상당히 많으므로 조건에 위배되는 경우(스택이 꽉참, 0으로 나누기 연산, 연산 결과가 	
	    (-)10억 ~ 10억 사이값, 최대 반복횟수, 최대 프로그램명령) 등을 에러 처리할것 발생할 수 있는  
        거의 모든 상황에 대해 에러처리했음.
        스택 템플릿을 사용하다가 push와 pop 하는데 복잡함을 느껴 배열로 구현.
        strcmp()함수가  아닌 getchar()로 한글자 씩 비교하였음
	
	
## Progress
- 최현석 : 1874, 3425
- 신광식 : 1068, 1991, 3425, 1874

