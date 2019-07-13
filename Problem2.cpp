//
// Created by shazmaan on 7/13/2019.
//
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Confusing to figure the logic out but easy once you do.
// Approach:
// update min throughout the array and calculate max by comparing 'current max' and 'current element' - min
//(kodec something algorithm)


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