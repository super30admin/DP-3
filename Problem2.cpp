//
// Created by shazmaan on 7/13/2019.
//

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minVal = INT_MAX; int maxVal = 0;
        for(int x = 0; x<prices.size(); x++){
            if(prices[x]<minVal){minVal = prices[x];}
            maxVal = max(maxVal,prices[x]-minVal);
        }
        return maxVal;
    }
};