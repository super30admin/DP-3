/*
Time Complexity :O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : not tried on Leetcode. It ran on my IDE with correct console output.
Any problem you faced while coding this : Implemented as explained in class.
*/

import java.util.*;

class buyAndSellStock{
    static int maxProfit(int[] prices) {

        if(prices == null || prices.length < 2) return 0;
        int minValue = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        return maxProfit;
    }

    public static void main(String[] args)
    {
        int[] prices = {7,1,5,3,6,4};
        System.out.print(maxProfit(prices));
    }
}