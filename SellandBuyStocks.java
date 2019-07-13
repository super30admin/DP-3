// Time Complexity :O(n) where n is the for loop for price
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :TNo


 //Arrays

class Solution {
    public int maxProfit(int[] prices) {
        
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        
        for(int i = 0; i<prices.length; i++)
        {
            if(prices[i]< minprice)
                minprice = prices[i];
            else if(prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        
        return maxprofit;
    }
}
