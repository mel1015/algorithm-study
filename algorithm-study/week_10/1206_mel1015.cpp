//
// Created by sks10 on 2018-07-05.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> buildings;

int view_point() {
    vector<int>::iterator index, beforeHigh, nextHigh;
    index = buildings.begin() + 2;

    int oneBefore, twoBefore, now, oneNext, twoNext, getView = 0;
    for (index; index != buildings.end(); ++index) {
        oneBefore = *(index - 1);
        twoBefore = *(index - 2);
        now = *index;
        oneNext = *(index + 1);
        twoNext = *(index + 2);

        if (twoBefore < now && oneBefore < now) {
            if (oneNext < now && twoNext < now) {
                beforeHigh = max_element(index - 2, index);
                nextHigh = max_element(index + 1, index + 3);

                if (*beforeHigh > *nextHigh)
                    getView += now - *beforeHigh;
                else
                    getView += now - *nextHigh;
            }
        }
    }
    return getView;
}

int main() {
    int testCase;
    for (int times = 1; times <= 10; ++times) {
        cin >> testCase;
        buildings.resize(testCase);
        for (int i = 0; i < testCase; ++i) {
            cin >> buildings[i];
        }
        cout << "#" << times << " " << view_point() << "\n";
        buildings.clear();
    }
    return 0;
}
