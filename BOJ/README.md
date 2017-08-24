# Tip

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
  - 초기화  
    - 전역변수 int, char, bool 은 모두 0으로 자동 초기화
    - 전역배열을 선언시 배열 전체가 자동으로 0으로 초기화
    - 지역배열은 초기화 해주지 않으면 쓰레기값이 들어간다.
    - 지역배열 선언시 초기화 할 땐 `int arr[10] = {0};` 또는 `int arr[10] = {0,};`으로 모든 원소를 0으로 초기화 할 수 있다.<br>
        `int arr[10] = {1};` 첫 원소에 1이 들어가고 나머지는 모두 0으로 초기화 된다.
    - 초기 값이 배열의 크기보다 많으면 에러, 적으면 나머지는 0으로, 배열 크기를 안쓰면 초기값의 개수에 맞춰서 배열 생성.