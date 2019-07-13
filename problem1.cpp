// Time Complexity : O(n) --> We iterate through the array once checking for minimum value while updating profit. 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

/*
1. Maximum Profit is the maximum value between the current maximum profit and difference between current selling price 
   and minimum purchase price 
2. Set maximum profit to 0 to handle edge cases when there is no profit.
*/


#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = INT_MAX;
        int profit = 0;
        
        for(int i = 0; i<prices.size(); i++)
        {
            if(prices[i] < minPrice)
                minPrice = prices[i];
            profit = max(profit, prices[i] - minPrice);
        }
        
        return profit;
    }
        
};;
