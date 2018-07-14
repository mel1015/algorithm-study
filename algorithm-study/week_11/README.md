> 문제를 풀면서 알게된 팁 공유

## To-Do List
- [SW Expert Academy](https://www.swexpertacademy.com/main/main.do)
    - 11주차 : [Part4](https://www.swexpertacademy.com/main/talk/solvingClub/problemBoxDetail.do?solveclubId=AV6kld8aisgDFASb&probBoxId=AV-4MojKLNADFATz&leftPage=1)
    
## Tip
- 신광식
    - [1244. 최대 상금](https://github.com/mel1015/algorithm-study/blob/1244/algorithm-study/week_11/1244_mel1015.cpp)
        - 문제를 여러 경우들로 쪼개고 각 경우마다를 처리함
        - 다른 사람들은 BFS를 사용해서 품
            - BFS를 사용하면 교환 횟수만큼 만들 수 있는 모든 숫자를 만들고 그중에 가장 큰 수를 리턴하는 방식
    - [1240. 단순 2진 암호코드](https://github.com/mel1015/algorithm-study/blob/1240/algorithm-study/week_11/1240_mel1015.cpp)
        - [std::string::string](http://www.cplusplus.com/reference/string/string/string/)
        - string의 constructor(생성자)에 iterator(반복자)로 문자열을 만드는 방법이 있음
        - iterator를 활용하면 편하다
    - [1228. 암호문1](https://github.com/mel1015/algorithm-study/blob/1228/algorithm-study/week_11/1228_mel1015.cpp)
        - [std::vector::insert](http://www.cplusplus.com/reference/vector/vector/insert/) 활용
    - [1230. 암호문3](https://github.com/mel1015/algorithm-study/blob/1230/algorithm-study/week_11/1230_mel1015.cpp)
        - [std::vector::erase](http://www.cplusplus.com/reference/vector/vector/erase/) 활용
        - [1228. 암호문1]에 내용 추가 + 모듈화
    - [1220. Magnetic](https://github.com/mel1015/algorithm-study/blob/1220/algorithm-study/week_11/1220_mel1015.cpp)
        - 문제에서 준 방식 그대로 무식하게 코딩함
        - 쉽게 해결하는 방법은 각 열에서 1이 나왔을 때 해당 열의 그 다음 값이 2이면 교착상태
        
## Progress
- 신광식 : 1244, 1240, 1234, 1228, 1230, 1220