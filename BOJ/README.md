# Tip

 - Fast I/O
    - cin보단 scanf가 빠르고 scanf보다 fastscan이 10배 빠르다
    - 시간제한이 있는 문제에서는 fastscan을 구현해서 쓰는게 효율적
    - 입력 속도
         1. using cin :- time= 1.30
         2. using scanf :- time= 0.52
         3. using cin with std::ios::sync_with _stdio(false); :- time = 0.44
         4. using cin with std::ios::sync_with _stdio(false); cin.tie(NULL); :- time=0.41
         5. using getchar :- time = 0.34
         6. using getchar_unlocked :- time = 0.15
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